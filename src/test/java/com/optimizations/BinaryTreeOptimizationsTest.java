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
        BinaryTreeOptimizations breadthFirstRecursive = new BinaryTreeOptimizations(totalCalls, totalIterations, target, KB);
        BinaryTreeOptimizations breadthFirstIterative = new BinaryTreeOptimizations(totalCalls, totalIterations, target, KB);

        BinaryTreeOptimizations invalidTarget = new BinaryTreeOptimizations(totalCalls, totalIterations, -1, KB);


        //WHEN
        depthFirstRecursive.execute("depthFirstRecursiveSearchTIME");
        depthFirstRecursive.execute("depthFirstRecursiveSearchMEMORY");

        depthFirstIterative.execute("depthFirstIterativeSearchTIME");
        depthFirstIterative.execute("depthFirstIterativeSearchMEMORY");

        breadthFirstRecursive.execute("breadthFirstRecursiveSearchTIME");
        breadthFirstRecursive.execute("breadthFirstRecursiveSearchMEMORY");

        breadthFirstIterative.execute("breadthFirstIterativeSearchTIME");
        breadthFirstIterative.execute("breadthFirstIterativeSearchMEMORY");

        //THEN
        Assertions.assertThrows(RuntimeException.class, invalidTarget::depthFirstRecursiveSearchTIME);
        Assertions.assertThrows(RuntimeException.class, invalidTarget::depthFirstRecursiveSearchMEMORY);

        Assertions.assertThrows(RuntimeException.class, invalidTarget::depthFirstIterativeSearchMEMORY);
        Assertions.assertThrows(RuntimeException.class, invalidTarget::depthFirstIterativeSearchMEMORY);

        Assertions.assertThrows(RuntimeException.class, invalidTarget::breadthFirstRecursiveSearchTIME);
        Assertions.assertThrows(RuntimeException.class, invalidTarget::breadthFirstRecursiveSearchMEMORY);

        Assertions.assertThrows(RuntimeException.class, invalidTarget::breadthFirstIterativeSearchTIME);
        Assertions.assertThrows(RuntimeException.class, invalidTarget::breadthFirstIterativeSearchMEMORY);

        Assertions.assertTrue(depthFirstRecursive.getAvgProcessTimeInNanoSeconds() < depthFirstIterative.getAvgProcessTimeInNanoSeconds());
        Assertions.assertTrue(breadthFirstRecursive.getAvgProcessTimeInNanoSeconds() < breadthFirstIterative.getAvgProcessTimeInNanoSeconds());
        Assertions.assertTrue(depthFirstRecursive.getAvgMemoryUsedInKb() > breadthFirstIterative.getAvgMemoryUsedInKb());
        Assertions.assertTrue(breadthFirstRecursive.getAvgMemoryUsedInKb() > breadthFirstIterative.getAvgMemoryUsedInKb());

        long recursiveTime = depthFirstRecursive.getAvgProcessTimeInNanoSeconds();
        long binaryTime = depthFirstIterative.getAvgProcessTimeInNanoSeconds();
        double recursiveMemory = depthFirstRecursive.getAvgMemoryUsedInKb();
        double binaryMemory = depthFirstIterative.getAvgMemoryUsedInKb();

        System.out.println("#".repeat(100));
        System.out.println("# ---------- BinaryTreeOptimizationsTest Depth-First Test Results ----------");
        System.out.println("# " + "Recursive average processing time:           " + depthFirstRecursive.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("# " + "Recursive average memory used:               " + depthFirstRecursive.getAvgMemoryUsedInKb() + " kb");
        System.out.println("# " + "Iterative average processing time:           " + depthFirstIterative.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("# " + "Iterative average memory used:               " + depthFirstIterative.getAvgMemoryUsedInKb() + " kb");
        System.out.println("# " + "-".repeat(100));
        System.out.println("# " + (recursiveTime < binaryTime ? "recursive" : "iterative") + " is faster by:                      " + (Math.max(recursiveTime, binaryTime) - Math.min(recursiveTime, binaryTime)) + " nanoseconds");
        System.out.println("# " + (recursiveMemory < binaryMemory ? "recursive" : "iterative") + " memory used is lower by:           " + (Math.max(recursiveMemory, binaryMemory) - Math.min(recursiveMemory, binaryMemory)) + " kb");
        System.out.println("#".repeat(100));

        System.out.println();

        recursiveTime = breadthFirstRecursive.getAvgProcessTimeInNanoSeconds();
        binaryTime = breadthFirstIterative.getAvgProcessTimeInNanoSeconds();
        recursiveMemory = breadthFirstRecursive.getAvgMemoryUsedInKb();
        binaryMemory = breadthFirstIterative.getAvgMemoryUsedInKb();

        System.out.println("#".repeat(100));
        System.out.println("# ---------- BinaryTreeOptimizationsTest Breadth-First Test Results ----------");
        System.out.println("# " + "Recursive average processing time:           " + breadthFirstRecursive.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("# " + "Recursive average memory used:               " + breadthFirstRecursive.getAvgMemoryUsedInKb() + " kb");
        System.out.println("# " + "Iterative average processing time:           " + breadthFirstIterative.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("# " + "Iterative average memory used:               " + breadthFirstIterative.getAvgMemoryUsedInKb() + " kb");
        System.out.println("# " + "-".repeat(100));
        System.out.println("# " + (recursiveTime < binaryTime ? "recursive" : "iterative") + " is faster by:                        " + (Math.max(recursiveTime, binaryTime) - Math.min(recursiveTime, binaryTime)) + " nanoseconds.");
        System.out.println("# " + (recursiveMemory < binaryMemory ? "recursive" : "iterative") + " memory used is lower by:             " + (Math.max(recursiveMemory, binaryMemory) - Math.min(recursiveMemory, binaryMemory)) + " kb.");
        System.out.println("#".repeat(100));
        System.out.println();
    }
}
