package com.optimizations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoopsAndStreamsOptimizationsTest {
    int totalCalls = 100;
    int totalIterations = 100000;

    @BeforeEach
    public void setup() throws InterruptedException {
        System.gc();
        Thread.sleep(1000);
    }

    @Test
    public void run() {
        //GIVEN
        LoopsAndStreamsOptimizations unOptimized = new LoopsAndStreamsOptimizations(totalCalls, totalIterations);
        LoopsAndStreamsOptimizations optimized = new LoopsAndStreamsOptimizations(totalCalls, totalIterations);

        //WHEN
        unOptimized.execute("unOptimizedTest");
        optimized.execute("optimizedTest");

        //THEN
        Assertions.assertTrue(unOptimized.getAvgProcessTimeInNanoSeconds() > optimized.getAvgProcessTimeInNanoSeconds());

        System.out.println("#".repeat(100));
        System.out.println("# ---------- LoopsAndStreams Test Results ----------");
        System.out.println("# " + "stream average processing time: " + unOptimized.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("# " + "loop average processing time:   " + optimized.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("# " + "-".repeat(100));
        System.out.println("# " + "loop speed improvement:           " + (unOptimized.getAvgProcessTimeInNanoSeconds() - optimized.getAvgProcessTimeInNanoSeconds()) + " nanoseconds");
        System.out.println("#".repeat(100));
        System.out.println();
    }
}
