package core.primitives.functions;

import core.primitives.AbstractFunction;

/** Función sucesor S(x) = x + 1. Aridad fija: 1. */
public class Successor extends AbstractFunction {
  /** Construye S con aridad 1. */
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
