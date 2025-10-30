package core.primitives.functions;

import core.primitives.AbstractFunction;

public class Successor extends AbstractFunction {
  public Successor() { super(1); }

  @Override
  public int apply(int... args) {
    tick();
    if (args.length != 1) {
      throw new IllegalArgumentException("Successor expects 1 arg");
    }
    return args[0] + 1;
  }
}
