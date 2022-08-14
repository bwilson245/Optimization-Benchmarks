package com.optimizations;

import com.Optimizations;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrencyOptimizations extends Optimizations {
    public ConcurrencyOptimizations(int totalCalls, int iterationCount) {
        super(totalCalls, iterationCount);
    }

    public void execute(String method) {
        for (int i = 0; i < totalCalls; i++) {
            System.gc();
            switch (method) {
                case "unOptimizedTest": {
                    addTime(unOptimizedTest());
                    break;
                }
                case "optimizedTest": {
                    addTime(optimizedTest());
                    break;
                }
                default:
            }
        }
        calculateAverageTime();
    }

    public long unOptimizedTest() {
        long time = System.nanoTime();
        int i;
        for (i = 0; i < iterationCount; i++) {
            simulatedLoad();
        }
        return System.nanoTime() - time;
    }

    public long optimizedTest() {
        ExecutorService service;
        long time = System.nanoTime();
        service = Executors.newCachedThreadPool();
        int i;
        for (i = 0; i < iterationCount; i++) {
            service.submit(this::simulatedLoad);
        }
        service.shutdown();
        try {
            service.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {}
        return System.nanoTime() - time;
    }

    public void simulatedLoad() {
        for (int i = 0; i < 9999; i++) {
            StringBuilder a = new StringBuilder("SIMULATED LOAD");
        }
    }
}
