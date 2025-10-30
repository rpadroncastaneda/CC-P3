package core.primitives.operations;

import core.primitives.AbstractFunction;
import core.primitives.PRFunction;

/**
 * Operador de recursión primitiva.
 * Dadas g (aridad n) y h (aridad n+2), construye f de aridad n+1 tal que:
 *  f(0, x⃗) = g(x⃗)
 *  f(k+1, x⃗) = h(k, f(k, x⃗), x⃗)
 * El primer argumento de f es el índice de recursión.
 */
public class PrimitiveRecursion extends AbstractFunction {
  private final PRFunction base_case;
  private final PRFunction recursive_step;

  /**
   * @param base_case caso base de aridad n
   * @param recursive_step paso recursivo de aridad n+2
   * @throws IllegalArgumentException si base_case/recursive_step son nulos o sus aridades no cumplen n y n+2
   */
  public PrimitiveRecursion(PRFunction base_case, PRFunction recursive_step) {
    super(base_case.arity() + 1);
    if (base_case == null || recursive_step == null) throw new IllegalArgumentException("null function");
    if (recursive_step.arity() != base_case.arity() + 2) {
      throw new IllegalArgumentException("recursive_step must have arity base_case.arity + 2");
    }
    this.base_case = base_case;
    this.recursive_step = recursive_step;
  }  

  @Override
  public int apply(int... args) {
    if (args.length != arity) {
      throw new IllegalArgumentException("PrimitiveRecursion: expected " + arity + " args, got " + args.length);
    }
    int elem = args[0];
    if (elem < 0) throw new IllegalArgumentException("Negative recursion index");
    int[] rest = new int[arity - 1];
    System.arraycopy(args, 1, rest, 0, rest.length);
    int value = base_case.apply(rest);
    for (int i = 0; i < elem; i++) {
      int[] hin = new int[recursive_step.arity()];
      hin[0] = i;
      hin[1] = value;
      System.arraycopy(rest, 0, hin, 2, rest.length);
      value = recursive_step.apply(hin);
    }
    return value;
  }
}
