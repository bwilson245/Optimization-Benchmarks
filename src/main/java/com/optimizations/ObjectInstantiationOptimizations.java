package com.optimizations;

import com.Optimizations;

public class ObjectInstantiationOptimizations extends Optimizations {
    public ObjectInstantiationOptimizations(int totalCalls, int iterationCount) {
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

    public long unOptimizedTest(){
        long time = System.nanoTime();
        for (int i = 0; i < iterationCount; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append("TEST".repeat(20));
        }
        return System.nanoTime() - time;
    }

    public long optimizedTest(){
        long time = System.nanoTime();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < iterationCount; i++) {
            builder.setLength(0);
            builder.append("TEST".repeat(20));
        }
        return System.nanoTime() - time;
    }
}
