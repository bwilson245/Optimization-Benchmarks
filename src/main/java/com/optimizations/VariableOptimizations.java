package com.optimizations;

import com.Optimizations;

public class VariableOptimizations extends Optimizations {

    public VariableOptimizations(int totalCalls, int iterationCount) {
        super(totalCalls, iterationCount);
    }

    public void execute(String method) {
        for (int i = 0; i < totalCalls; i++) {
            System.gc();
            switch (method) {
                case "IntegerTest": {
                    addTime(IntegerTest());
                    break;
                }
                case "intTest": {
                    addTime(intTest());
                    break;
                }
                case "DoubleTest": {
                    addTime(DoubleTest());
                    break;
                }
                case "doubleTest": {
                    addTime(doubleTest());
                    break;
                }
                case "LongTest": {
                    addTime(LongTest());
                    break;
                }
                case "longTest": {
                    addTime(longTest());
                    break;
                }
                case "FloatTest": {
                    addTime(FloatTest());
                    break;
                }
                case "floatTest": {
                    addTime(floatTest());
                    break;
                }
                case "CharacterTest": {
                    addTime(CharacterTest());
                    break;
                }
                case "charTest": {
                    addTime(charTest());
                    break;
                }
                default:
            }
        }
        calculateAverageTime();
    }

    public long IntegerTest() {
        long time = System.nanoTime();
        for (int i = 0; i < iterationCount; i++) {
            Integer test = 1;
        }
        return System.nanoTime() - time;
    }

    public long intTest() {
        long time = System.nanoTime();
        for (int i = 0; i < iterationCount; i++) {
            int test = 1;
        }
        return System.nanoTime() - time;
    }

    public long DoubleTest() {
        long time = System.nanoTime();
        for (int i = 0; i < iterationCount; i++) {
            Double test = 1.0;
        }
        return System.nanoTime() - time;
    }

    public long doubleTest() {
        long time = System.nanoTime();
        for (int i = 0; i < iterationCount; i++) {
            double test = 1.0;
        }
        return System.nanoTime() - time;
    }

    public long LongTest() {
        long time = System.nanoTime();
        for (int i = 0; i < iterationCount; i++) {
            Long test = 1L;
        }
        return System.nanoTime() - time;
    }

    public long longTest() {
        long time = System.nanoTime();
        for (int i = 0; i < iterationCount; i++) {
            long test = 1L;
        }
        return System.nanoTime() - time;
    }

    public long FloatTest() {
        long time = System.nanoTime();
        for (int i = 0; i < iterationCount; i++) {
            Float test = 1.0f;
        }
        return System.nanoTime() - time;
    }

    public long floatTest() {
        long time = System.nanoTime();
        for (int i = 0; i < iterationCount; i++) {
            float test = 1.0f;
        }
        return System.nanoTime() - time;
    }

    public long CharacterTest() {
        long time = System.nanoTime();
        for (int i = 0; i < iterationCount; i++) {
            Character test = 'a';
        }
        return System.nanoTime() - time;
    }

    public long charTest() {
        long time = System.nanoTime();
        for (int i = 0; i < iterationCount; i++) {
            char test = 'a';
        }
        return System.nanoTime() - time;
    }
}
