import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchBenchmarkTest implements TestInterface {
    int totalCalls = 100;
    int totalIterations = 1000;
    int target = totalIterations - 1;

    @Test
    public void run() {
        //GIVEN
        BinarySearchBenchmark unOptimized = new BinarySearchBenchmark(totalCalls, totalIterations, target);
        BinarySearchBenchmark optimized = new BinarySearchBenchmark(totalCalls, totalIterations, target);

        //WHEN
        unOptimized.unOptimizedTest();
        optimized.optimizedTest();

        //THEN
        Assertions.assertTrue(unOptimized.getAvgProcessTimeInNanoSeconds() > optimized.getAvgProcessTimeInNanoSeconds());

        System.out.println("*".repeat(100));
        System.out.println("* ---------- BinarySearchBenchmark Test Results ----------");
        System.out.println("* " + "unOptimized average processing time: " + unOptimized.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("* " + "optimized average processing time:   " + optimized.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("-".repeat(100));
        System.out.println("* " + "overall speed improvement:           " + (unOptimized.getAvgProcessTimeInNanoSeconds() - optimized.getAvgProcessTimeInNanoSeconds()) + " nanoseconds");
        System.out.println("*".repeat(100));
        System.out.println();
    }

}
