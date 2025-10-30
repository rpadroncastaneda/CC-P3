package core.primitives.functions;

import core.primitives.AbstractFunction;

/**
 * Función cero Z^n: devuelve 0 para cualquier tupla de entrada de longitud n.
 * La aridad se fija en construcción.
 */
public class Zero extends AbstractFunction {
  /**
   * Crea Z^n para la aridad indicada.
   * @param arity número de parámetros que aceptará esta función
   */
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
