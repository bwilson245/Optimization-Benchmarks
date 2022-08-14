package com.optimizations;

import com.OptimizationsInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinaryTreeOptimizationsTest implements OptimizationsInterface {
    int totalCalls = 20;
    int totalIterations = 1000;
    int target = totalIterations - 1;
    final String KB = "Kb";
    final String MB = "Mb";
    final String GB = "Gb";

    @BeforeEach
    public void setup() throws InterruptedException {
        System.gc();
        Thread.sleep(100);
    }

    @Test
    public void run() {
        //GIVEN
        BinaryTreeOptimizations depthFirstRecursive = new BinaryTreeOptimizations(totalCalls, totalIterations, target, KB);
        BinaryTreeOptimizations depthFirstIterative = new BinaryTreeOptimizations(totalCalls, totalIterations, target, KB);
        BinaryTreeOptimizations breadthFirstIterative = new BinaryTreeOptimizations(totalCalls, totalIterations, target, KB);

        BinaryTreeOptimizations invalidTarget = new BinaryTreeOptimizations(totalCalls, totalIterations, -1, KB);


        //WHEN
        depthFirstRecursive.execute("depthFirstRecursiveSearchTIME");
        depthFirstRecursive.execute("depthFirstRecursiveSearchMEMORY");

        depthFirstIterative.execute("depthFirstIterativeSearchTIME");
        depthFirstIterative.execute("depthFirstIterativeSearchMEMORY");

        breadthFirstIterative.execute("breadthFirstIterativeSearchTIME");
        breadthFirstIterative.execute("breadthFirstIterativeSearchMEMORY");

        //THEN
        Assertions.assertThrows(RuntimeException.class, invalidTarget::depthFirstRecursiveSearchTIME);
        Assertions.assertThrows(RuntimeException.class, invalidTarget::depthFirstRecursiveSearchMEMORY);
        Assertions.assertThrows(RuntimeException.class, invalidTarget::depthFirstIterativeSearchMEMORY);
        Assertions.assertThrows(RuntimeException.class, invalidTarget::depthFirstIterativeSearchMEMORY);
        Assertions.assertThrows(RuntimeException.class, invalidTarget::breadthFirstIterativeSearchTIME);
        Assertions.assertThrows(RuntimeException.class, invalidTarget::breadthFirstIterativeSearchMEMORY);

        Assertions.assertTrue(depthFirstRecursive.getAvgProcessTimeInNanoSeconds() < depthFirstIterative.getAvgProcessTimeInNanoSeconds());
        Assertions.assertTrue(depthFirstRecursive.getAvgMemoryUsedInKb() > breadthFirstIterative.getAvgMemoryUsedInKb());

        long recursiveTime = depthFirstRecursive.getAvgProcessTimeInNanoSeconds();
        long depthFirstTime = depthFirstIterative.getAvgProcessTimeInNanoSeconds();
        double recursiveMemory = depthFirstRecursive.getAvgMemoryUsedInKb();
        double depthFirstMemory = depthFirstIterative.getAvgMemoryUsedInKb();

        System.out.println("#".repeat(100));
        System.out.println("# ---------- BinaryTreeOptimizationsTest Depth-First Test Results ----------");
        System.out.println("# " + "Recursive average processing time:           " + depthFirstRecursive.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("# " + "Recursive average memory used:               " + depthFirstRecursive.getAvgMemoryUsedInKb() + " kb");
        System.out.println("# " + "Iterative average processing time:           " + depthFirstIterative.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("# " + "Iterative average memory used:               " + depthFirstIterative.getAvgMemoryUsedInKb() + " kb");
        System.out.println("# " + "-".repeat(100));
        System.out.println("# " + (recursiveTime < depthFirstTime ? "recursive" : "iterative") + " is faster by:                      " + (Math.max(recursiveTime, depthFirstTime) - Math.min(recursiveTime, depthFirstTime)) + " nanoseconds");
        System.out.println("# " + (recursiveMemory < depthFirstMemory ? "recursive" : "iterative") + " memory used is lower by:           " + (Math.max(recursiveMemory, depthFirstMemory) - Math.min(recursiveMemory, depthFirstMemory)) + " kb");
        System.out.println("#".repeat(100));

        System.out.println();

        long breadthFirstTime = breadthFirstIterative.getAvgProcessTimeInNanoSeconds();
        double breadthFirstMemory = breadthFirstIterative.getAvgMemoryUsedInKb();

        System.out.println("#".repeat(100));
        System.out.println("# ---------- BinaryTreeOptimizationsTest Iterative Test Results ----------");
        System.out.println("# " + "Depth-First average processing time:           " + depthFirstIterative.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("# " + "Depth-First average memory used:               " + depthFirstIterative.getAvgMemoryUsedInKb() + " kb");
        System.out.println("# " + "Breadth-First average processing time:         " + breadthFirstIterative.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("# " + "Breadth-First average memory used:             " + breadthFirstIterative.getAvgMemoryUsedInKb() + " kb");
        System.out.println("# " + "-".repeat(100));
        System.out.println("# " + (breadthFirstTime < depthFirstTime ? "Breadth-First" : "Depth-First") + " is faster by:                        " + (Math.max(breadthFirstTime, depthFirstTime) - Math.min(breadthFirstTime, depthFirstTime)) + " nanoseconds.");
        System.out.println("# " + (breadthFirstMemory <= depthFirstMemory ? "Breadth-First" : "Depth-First") + " memory used is lower by:             " + (Math.max(breadthFirstMemory, depthFirstMemory) - Math.min(breadthFirstMemory, depthFirstMemory)) + " kb.");
        System.out.println("#".repeat(100));
        System.out.println();
    }
}
