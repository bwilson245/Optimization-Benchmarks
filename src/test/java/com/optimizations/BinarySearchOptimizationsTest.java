package com.optimizations;

import com.OptimizationsInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinarySearchOptimizationsTest implements OptimizationsInterface {
    int totalCalls = 20;
    int totalIterations = 10000;
    int target = totalIterations - 1;

    @BeforeEach
    public void setup() throws InterruptedException {
        System.gc();
        Thread.sleep(100);
    }

    @Test
    public void run() {
        //GIVEN
        BinarySearchOptimizations unOptimized = new BinarySearchOptimizations(totalCalls, totalIterations, target);
        BinarySearchOptimizations optimized = new BinarySearchOptimizations(totalCalls, totalIterations, target);

        //WHEN
        unOptimized.execute("unOptimized");
        optimized.execute("optimized");

        //THEN
        Assertions.assertTrue(unOptimized.getAvgProcessTimeInNanoSeconds() > optimized.getAvgProcessTimeInNanoSeconds());

        System.out.println("#".repeat(100));
        System.out.println("# ---------- BinarySearchOptimizationsTest Test Results ----------");
        System.out.println("# " + "unOptimized average processing time: " + unOptimized.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("# " + "optimized average processing time:   " + optimized.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("# " + "-".repeat(100));
        System.out.println("# " + "overall speed improvement:           " + (unOptimized.getAvgProcessTimeInNanoSeconds() - optimized.getAvgProcessTimeInNanoSeconds()) + " nanoseconds");
        System.out.println("#".repeat(100));
        System.out.println();
    }

}
