package core;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Contador global y thread-safe de invocaciones a funciones PR.
 *
 * Filosofía de conteo: cada llamada a {@code apply} de cualquier función
 * primitiva u operador (cero, sucesor, proyección, composición y recursión)
 * incrementa este contador. Por tanto, el valor refleja el coste real de
 * evaluar la construcción PR, no solo llamadas de alto nivel.
 */
public final class CallCounter {
    private static final AtomicLong counter = new AtomicLong(0);

    private CallCounter() {}

    public static void reset() {
        counter.set(0);
    }

    public static void tick() {
        counter.incrementAndGet();
    }

    /**
     * Obtiene el valor actual del contador.
     * @return número total de invocaciones registradas
     */
    public static long get() {
        return counter.get();
    }
}
