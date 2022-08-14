package com.optimizations;

import com.Optimizations;

public class BinarySearchOptimizations extends Optimizations {
    int target;
    int[] array;

    public BinarySearchOptimizations(int totalCalls, int iterationCount, int target) {
        super(totalCalls, iterationCount);
        this.target = target;
        this.array = buildArray(iterationCount);
    }

    public void execute(String method) {
        for (int i = 0; i < totalCalls; i++) {
            System.gc();
            switch (method) {
                case "unOptimized": {
                    addTime(unOptimizedTest());
                    break;
                }
                case "optimized": {
                    addTime(optimizedTest());
                    break;
                }
                default:
            }
        }
        calculateAverageTime();
    }

    private long unOptimizedTest() {
        long time = System.nanoTime();
        for (int i = 0; i < iterationCount; i++) {
            if (array[i] == target) {
                break;
            }
        }
        return System.nanoTime() - time;
    }

    private long optimizedTest() {
        long time = System.nanoTime();
        int high = array.length - 1;
        int low = 0;
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (mid == target) {
                break;
            }
            if (target > mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return System.nanoTime() - time;
    }

    private int[] buildArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = i;
        }
        return result;
    }
}
