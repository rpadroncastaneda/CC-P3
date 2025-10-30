package core.primitives;

/**
 * Contrato común de una función recursiva primitiva (PR).
 * Las implementaciones deben declarar su aridad y definir {@link #apply(int...)}.
 */
public interface PRFunction {
  /**
   * Número de argumentos que acepta esta función.
   * Debe coincidir exactamente con la longitud del array en {@link #apply(int...)}.
   */
  int arity();

  /**
   * Evalúa la función sobre los argumentos dados.
   * @param args tupla de entrada; su longitud debe ser igual a {@link #arity()}.
   * @return resultado entero no negativo (siempre que las construcciones PR se apliquen sobre N)
   * @throws IllegalArgumentException si la longitud de {@code args} no coincide o si la implementación lo requiere
   */
  int apply(int... args);
}
