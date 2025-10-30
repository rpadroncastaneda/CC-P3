package core;

import core.primitives.PRFunction;
import core.primitives.functions.Projection;
import core.primitives.functions.Successor;
import core.primitives.functions.Zero;
import core.primitives.operations.Composition;
import core.primitives.operations.PrimitiveRecursion;



public final class Potencia {
  private Potencia() {}  

  public static PRFunction build() {
    PRFunction add = buildAdd();
    PRFunction mult = buildMult(add);
    PRFunction g = new Composition(new Successor(), new PRFunction[]{ new Zero(1) }); 
    PRFunction h = new Composition(mult, new PRFunction[]{ new Projection(2,3), new Projection(3,3) });
    PRFunction f_yx = new PrimitiveRecursion(g, h); 
    return new Composition(f_yx, new PRFunction[]{ new Projection(2,2), new Projection(1,2) });
  }  

  private static PRFunction buildAdd() {
    PRFunction g = new Projection(1, 1);
    PRFunction s = new Successor();
    PRFunction h = new Composition(s, new PRFunction[]{ new Projection(2,3) });
    PRFunction add_ky = new PrimitiveRecursion(g, h);
    return add_ky;
  } 

  private static PRFunction buildMult(PRFunction add) {
    PRFunction g = new Zero(1);
    PRFunction h = new Composition(add, new PRFunction[]{ new Projection(2,3), new Projection(3,3) });
    return new PrimitiveRecursion(g, h);
  }
}
