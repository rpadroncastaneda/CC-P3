package core.primitives.operations;

import core.primitives.AbstractFunction;
import core.primitives.PRFunction;

/**
 * Operador de composición: dada {@code outer} de aridad m y un array de funciones
 * {@code inners} de longitud m y aridad n, construye una función de aridad n que mapea
 * x⃗ ↦ outer( inners[0](x⃗), ..., inners[m-1](x⃗) ).
 *
 * Requisitos: todas las inners deben tener la misma aridad n; {@code outer.arity() == inners.length}.
 */
public class Composition extends AbstractFunction {
  private final PRFunction outer;
  private final PRFunction[] inners;  

  /**
   * Crea la composición de {@code outer} con {@code inners}.
   * @param outer función externa (de aridad m)
   * @param inners funciones internas (longitud m), cada una de aridad n
   * @throws IllegalArgumentException si hay nulls o si las aridades no son coherentes
   */
  public Composition(PRFunction outer, PRFunction[] inners) {
    super(determineArity(inners));
    if (outer == null || inners == null) throw new IllegalArgumentException("null function");
    if (outer.arity() != inners.length) {
      throw new IllegalArgumentException("Outer arity must match number of inner functions");
    }
    this.outer = outer;
    this.inners = inners.clone();
  }  

  private static int determineArity(PRFunction[] inners) {
    if (inners.length == 0) return 0;
    return inners[0].arity();
  }  

  @Override
  public int apply(int... args) {
    int n = arity;
    if (args.length != n) {
      throw new IllegalArgumentException("Composition: expected " + n + " args, got " + args.length);
    }
    int[] results = new int[inners.length];
    for (int i = 0; i < inners.length; i++) {
      results[i] = inners[i].apply(args);
    }
    return outer.apply(results);
  }
}
