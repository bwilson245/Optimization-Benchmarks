import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ObjectInstantiationBenchmarkTest implements TestInterface {
    int totalCalls = 100;
    int totalIterations = 1000;

    @Test
    public void run() {
        //GIVEN
        ObjectInstantiationBenchmark unOptimized = new ObjectInstantiationBenchmark(totalCalls, totalIterations);
        ObjectInstantiationBenchmark optimized = new ObjectInstantiationBenchmark(totalCalls, totalIterations);

        //WHEN
        unOptimized.unOptimizedTest();
        optimized.optimizedTest();

        //THEN
        Assertions.assertTrue(unOptimized.getAvgProcessTimeInNanoSeconds() > optimized.getAvgProcessTimeInNanoSeconds());

        System.out.println("*".repeat(100));
        System.out.println("* ---------- ObjectInstantiationBenchmark Test Results ----------");
        System.out.println("* " + "unOptimized average processing time in nanoseconds: " + unOptimized.getAvgProcessTimeInNanoSeconds());
        System.out.println("* " + "optimized average processing time in nanoseconds:   " + optimized.getAvgProcessTimeInNanoSeconds());
        System.out.println("* " + "overall speed improvement in nanoseconds:           " + (unOptimized.getAvgProcessTimeInNanoSeconds() - optimized.getAvgProcessTimeInNanoSeconds()));
        System.out.println("*".repeat(100));
        System.out.println();
    }
}
