package core.primitives.functions;

import core.primitives.AbstractFunction;

public class Projection extends AbstractFunction {
  private final int index;   

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
