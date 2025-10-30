package core.primitives.functions;

import core.primitives.AbstractFunction;

public class Zero extends AbstractFunction {
  public Zero(int arity) { super(arity); }

  @Override
  public int apply(int... args) {
    tick();
    if (args.length != arity) {
      throw new IllegalArgumentException("Zero: expected " + arity + " args, got " + args.length);
    }
    return 0;
  }
}
