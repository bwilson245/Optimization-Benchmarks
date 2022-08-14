package com.utility;

public class MemoryTester {
    public static double getUsedMemory(String memType) {
        double kb = 1024;
        double mb = (int) Math.pow(kb, 2);
        double gb = (int) Math.pow(mb, 2);
        Runtime runtime = Runtime.getRuntime();

        switch (memType) {
            case "Kb" : {
                return (double) (runtime.totalMemory() - runtime.freeMemory()) / kb;
            }
            case "Mb" : {
                return (double) (runtime.totalMemory() - runtime.freeMemory()) / mb;
            }
            case "Gb" : {
                return (double) (runtime.totalMemory() - runtime.freeMemory()) / gb;
            }
            default: {
                return -1.0;
            }
        }
    }
}
