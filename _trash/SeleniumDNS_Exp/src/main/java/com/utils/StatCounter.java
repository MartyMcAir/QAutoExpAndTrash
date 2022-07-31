package com.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class StatCounter {
    private static final AtomicInteger atom = new AtomicInteger();

    public StatCounter() {
        atom.getAndIncrement();
    }

    public static int get() {
        return atom.get();
    }

    public static int increment() {
        return atom.getAndIncrement();
    }
}
