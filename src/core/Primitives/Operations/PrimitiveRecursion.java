package core.primitives.operations;

import core.primitives.AbstractFunction;
import core.primitives.PRFunction;

public class PrimitiveRecursion extends AbstractFunction {
  private final PRFunction g;
  private final PRFunction h;  

  public PrimitiveRecursion(PRFunction g, PRFunction h) {
    super(g.arity() + 1);
    if (g == null || h == null) throw new IllegalArgumentException("null function");
    if (h.arity() != g.arity() + 2) {
      throw new IllegalArgumentException("h must have arity g.arity + 2");
    }
    this.g = g;
    this.h = h;
  }  

  @Override
  public int apply(int... args) {
    tick();
    if (args.length != arity) {
      throw new IllegalArgumentException("PrimitiveRecursion: expected " + arity + " args, got " + args.length);
    }
    int k = args[0];
    if (k < 0) throw new IllegalArgumentException("Negative recursion index");
    int[] rest = new int[arity - 1];
    System.arraycopy(args, 1, rest, 0, rest.length);
    int value = g.apply(rest);
    for (int i = 0; i < k; i++) { 
      int[] hin = new int[h.arity()];
      hin[0] = i;
      hin[1] = value;
      System.arraycopy(rest, 0, hin, 2, rest.length);
      value = h.apply(hin);
    }
    return value;
  }
}
