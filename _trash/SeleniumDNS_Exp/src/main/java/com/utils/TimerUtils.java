package com.utils;

import org.apache.commons.lang3.tuple.Pair;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;

public class TimerUtils {
    private Instant start, startMain, end;
    private static final AtomicInteger atom = new AtomicInteger();
    private static final AtomicInteger atomMain = new AtomicInteger();
    public static final int oneMilliSecond_inNano = 1_000_000;
    public static final int oneSecond_inNano = oneMilliSecond_inNano * 1000;

    public void startTimer() {
        this.start = Instant.now();
        this.startMain = Instant.now();
    }

    public long getAndShowCountedTime() {
        Instant currentEndTime = Instant.now();
        Pair<String, Long> pair = getPairForCurrentTime(start, currentEndTime);

        System.out.println("#" + atom.getAndIncrement() + "_ counted time: " + pair.getRight() + pair.getLeft());
        this.start = currentEndTime;
        return pair.getRight();
    }

    public long getAndShowMainTimer() {
        Instant currentEndTime = Instant.now();
        Pair<String, Long> pair = getPairForCurrentTime(startMain, currentEndTime);

        System.out.println("Main counter #" + atomMain.getAndIncrement() + " Total counted time in main timer: "
                + pair.getRight() + pair.getLeft());
        this.startMain = currentEndTime;
        return pair.getRight();
    }

    private Pair<String, Long> getPairForCurrentTime(Instant startTime, Instant endTime) {
        long nano = Math.round(Duration.between(startTime, endTime).toNanos());
        long millis = Math.round(Duration.between(startTime, endTime).toMillis());
        long seconds = Math.round(Duration.between(startTime, endTime).toSeconds());
        long minutes = Math.round(Duration.between(startTime, endTime).toMinutes());

        Pair<String, Long> pair = Pair.of(" nanoSeconds.", nano);
        if (nano > 1_000_000) pair = Pair.of(" milliSeconds.", millis);
        if (millis > 1000) pair = Pair.of(" seconds.", seconds);
        if (seconds > 60) pair = Pair.of(" minutes.", minutes);
        return pair;
    }

}