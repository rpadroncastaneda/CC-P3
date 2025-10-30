package core.primitives.functions;

import core.primitives.AbstractFunction;

/**
 * Proyección P(i, n): devuelve el i-ésimo componente (1-based) de una tupla de aridad n.
 */
public class Projection extends AbstractFunction {
  private final int index;   

  /**
   * Crea P(i, n).
   * @param index índice 1-based del componente a devolver (1 ≤ index ≤ arity)
   * @param arity aridad n de la tupla de entrada
   * @throws IllegalArgumentException si index no está en el rango [1, arity]
   */
  public Projection(int index, int arity) {
    super(arity);
    if (index < 1 || index > arity) {
      throw new IllegalArgumentException("Projection: index out of range");
    }
    this.index = index;
  }  

  @Override
  public int apply(int... args) {
    tick();
    if (args.length != arity) {
      throw new IllegalArgumentException("Projection: expected " + arity + " args, got " + args.length);
    }
    return args[index - 1];
  }
}
