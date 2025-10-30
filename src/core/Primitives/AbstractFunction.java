package core.primitives;

import core.CallCounter;

/**
 * Base abstracta para funciones PR con almacenamiento de aridad y utilidades
 * comunes. Provee {@link #tick()} para registrar invocaciones en el contador global.
 */
public abstract class AbstractFunction implements PRFunction {
  /** Aridad (número de parámetros) de la función. */
  protected final int arity;  

  /**
   * Crea una función PR con la aridad indicada.
   * @param arity número de argumentos que debe recibir en cada {@link #apply(int...)}
   */
  protected AbstractFunction(int arity) { this.arity = arity;}  

  @Override
  public int arity() { return arity; }  

  /** Marca una invocación en el contador global. Úsese al inicio de apply(). */
  protected final void tick() { CallCounter.tick(); }
}
