package com.optimizations;

import com.Optimizations;

import java.util.ArrayList;
import java.util.List;

public class LoopsAndStreamsOptimizations extends Optimizations {
    public LoopsAndStreamsOptimizations(int totalCalls, int iterationCount) {
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

    private long unOptimizedTest() {
        List<Integer> list = buildList();
        long time = System.nanoTime();
        list.forEach(i -> {});
        return System.nanoTime() - time;
    }

    private long optimizedTest() {
        List<Integer> list = buildList();
        long time = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
        }
        return System.nanoTime() - time;
    }

    private List<Integer> buildList() {
        List<Integer> list = new ArrayList<>();
        int i;
        for (i = 0; i < iterationCount; i++) {
            list.add(i);
        }
        return list;
    }
}
