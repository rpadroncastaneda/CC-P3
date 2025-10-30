package core;

import java.util.concurrent.atomic.AtomicLong;

public final class CallCounter {
    private static final AtomicLong counter = new AtomicLong(0);

    private CallCounter() {}

    public static void reset() {
        counter.set(0);
    }

    public static void tick() {
        counter.incrementAndGet();
    }

    public static long get() {
        return counter.get();
    }
}
