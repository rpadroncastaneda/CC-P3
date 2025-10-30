package core.primitives;

import core.CallCounter;

public abstract class AbstractFunction implements PRFunction {
  protected final int arity;  

  protected AbstractFunction(int arity) { this.arity = arity;}  
  @Override
  public int arity() { return arity; }  
  protected final void tick() { CallCounter.tick(); }
}
