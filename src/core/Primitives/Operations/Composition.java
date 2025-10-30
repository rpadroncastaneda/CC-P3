package core.primitives.operations;

import core.primitives.AbstractFunction;
import core.primitives.PRFunction;

public class Composition extends AbstractFunction {
  private final PRFunction outer;
  private final PRFunction[] inners;  

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
    tick();
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
