import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryTreeBenchmarkTest implements TestInterface{
    int totalCalls = 100;
    int totalIterations = 1000;
    int target = totalIterations - 1;
    final String KB = "Kb";
    final String MB = "Mb";
    final String GB = "Gb";

    @Test
    public void run() {
        //GIVEN
        BinaryTreeBenchmark depthFirstRecursive = new BinaryTreeBenchmark(totalCalls, totalIterations, target, KB);
        BinaryTreeBenchmark depthFirstIterative = new BinaryTreeBenchmark(totalCalls, totalIterations, target, KB);
        BinaryTreeBenchmark breadthFirstRecursive = new BinaryTreeBenchmark(totalCalls, totalIterations, target, KB);
        BinaryTreeBenchmark breadthFirstIterative = new BinaryTreeBenchmark(totalCalls, totalIterations, target, KB);

        BinaryTreeBenchmark invalidTarget = new BinaryTreeBenchmark(totalCalls, totalIterations, -1, KB);


        //WHEN
        depthFirstRecursive.depthFirstRecursiveSearchTIME();
        depthFirstRecursive.depthFirstRecursiveSearchMEMORY();

        depthFirstIterative.depthFirstIterativeSearchTIME();
        depthFirstIterative.depthFirstIterativeSearchMEMORY();

        breadthFirstRecursive.breadthFirstRecursiveSearchTIME();
        breadthFirstRecursive.breadthFirstRecursiveSearchMEMORY();

        breadthFirstIterative.breadthFirstIterativeSearchTIME();
        breadthFirstIterative.breadthFirstIterativeSearchMEMORY();

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

        System.out.println("*".repeat(100));
        System.out.println("* ---------- BinaryTreeBenchmark Recursive Test Results ----------");
        System.out.println("* " + "Recursive average processing time:           " + depthFirstRecursive.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("* " + "Recursive average memory used:               " + depthFirstRecursive.getAvgMemoryUsedInKb() + " kb");
        System.out.println("* " + "Iterative average processing time:           " + depthFirstIterative.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("* " + "Iterative average memory used:               " + depthFirstIterative.getAvgMemoryUsedInKb() + " kb");
        System.out.println("-".repeat(100));
        System.out.println("* " + (recursiveTime < binaryTime ? "recursive" : "iterative") + " is faster by:                      " + (Math.max(recursiveTime, binaryTime) - Math.min(recursiveTime, binaryTime)) + " nanoseconds");
        System.out.println("* " + (recursiveMemory < binaryMemory ? "recursive" : "iterative") + " memory used is lower by:           " + (Math.max(recursiveMemory, binaryMemory) - Math.min(recursiveMemory, binaryMemory)) + " kb");
        System.out.println("*".repeat(100));

        System.out.println();

        recursiveTime = breadthFirstRecursive.getAvgProcessTimeInNanoSeconds();
        binaryTime = breadthFirstIterative.getAvgProcessTimeInNanoSeconds();
        recursiveMemory = breadthFirstRecursive.getAvgMemoryUsedInKb();
        binaryMemory = breadthFirstIterative.getAvgMemoryUsedInKb();

        System.out.println("*".repeat(100));
        System.out.println("* ---------- BinaryTreeBenchmark Breadth-First Test Results ----------");
        System.out.println("* " + "Recursive average processing time:           " + breadthFirstRecursive.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("* " + "Recursive average memory used:               " + breadthFirstRecursive.getAvgMemoryUsedInKb() + " kb");
        System.out.println("* " + "Iterative average processing time:           " + breadthFirstIterative.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("* " + "Iterative average memory used:               " + breadthFirstIterative.getAvgMemoryUsedInKb() + " kb");
        System.out.println("-".repeat(100));
        System.out.println("* " + (recursiveTime < binaryTime ? "recursive" : "iterative") + " is faster by:                        " + (Math.max(recursiveTime, binaryTime) - Math.min(recursiveTime, binaryTime)) + " nanoseconds.");
        System.out.println("* " + (recursiveMemory < binaryMemory ? "recursive" : "iterative") + " memory used is lower by:             " + (Math.max(recursiveMemory, binaryMemory) - Math.min(recursiveMemory, binaryMemory)) + " kb.");
        System.out.println("*".repeat(100));
        System.out.println();
    }
}
