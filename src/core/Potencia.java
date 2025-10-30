package core;

import core.primitives.PRFunction;
import core.primitives.functions.Projection;
import core.primitives.functions.Successor;
import core.primitives.functions.Zero;
import core.primitives.operations.Composition;
import core.primitives.operations.PrimitiveRecursion;

/**
 * Factoría de la función potencia pow(x, y) = x^y construida mediante recursión primitiva.
 *
 * Definición usada (recursión sobre y):
 *  - g(x) = 1
 *  - h(k, z, x) = mult(z, x)
 *  - f(0, x) = g(x), f(y+1, x) = h(y, f(y, x), x)
 * Se expone en orden (x, y) componiendo con una permutación de argumentos.
 */
public final class Potencia {
  private Potencia() {}  

  /**
   * Construye una función PR de aridad 2 que implementa pow(x, y).
   * @return función PR que, al aplicar (x, y), devuelve x^y
   */
  public static PRFunction build() {
    PRFunction addition = buildAdd();
    PRFunction multiplication = buildMult(addition);
    PRFunction baseCasePow = new Composition(new Successor(), new PRFunction[]{ new Zero(1) });
    PRFunction recursiveStepPow = new Composition(multiplication, new PRFunction[]{ new Projection(2,3), new Projection(3,3) });
    PRFunction pow_yx = new PrimitiveRecursion(baseCasePow, recursiveStepPow);
    return new Composition(pow_yx, new PRFunction[]{ new Projection(2,2), new Projection(1,2) });
  }  

  /**
   * Suma add(x, y) mediante recursión sobre el primer argumento.
   *  add(0, y) = y; add(k+1, y) = S(add(k, y))
   */
  private static PRFunction buildAdd() {
    PRFunction baseCaseAdd = new Projection(1, 1);
    PRFunction successor = new Successor();
    PRFunction recursiveStepAdd = new Composition(successor, new PRFunction[]{ new Projection(2,3) });
    PRFunction addRec = new PrimitiveRecursion(baseCaseAdd, recursiveStepAdd);
    return addRec;
  } 

  /**
   * Multiplicación mult(x, y) como suma repetida vía PR en el primer argumento.
   *  mult(0, y) = 0; mult(k+1, y) = add(mult(k, y), y)
   */
  private static PRFunction buildMult(PRFunction addition) {
    PRFunction baseCaseMult = new Zero(1);
    PRFunction recursiveStepMult = new Composition(addition, new PRFunction[]{ new Projection(2,3), new Projection(3,3) });
    return new PrimitiveRecursion(baseCaseMult, recursiveStepMult);
  }
}
