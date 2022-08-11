import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ObjectInstantiationBenchmarkTest {
    int totalCalls = 200;
    int totalIterations = 1000000;

    @Test
    public void instantiation_sameValues_optimizedIsFaster() {
        //GIVEN
        ObjectInstantiationBenchmark unOptimized = new ObjectInstantiationBenchmark(totalCalls, totalIterations);
        ObjectInstantiationBenchmark optimized = new ObjectInstantiationBenchmark(totalCalls, totalIterations);

        //WHEN
        unOptimized.unOptimizedInstantiation();
        optimized.optimizedInstantiation();

        //THEN
        Assertions.assertTrue(unOptimized.getAvgProcessTimeInNanoSeconds() > optimized.getAvgProcessTimeInNanoSeconds());

        System.out.println("*".repeat(200));
        System.out.println("* " + "unOptimized instantiation average processing time in nanoseconds: " + unOptimized.getAvgProcessTimeInNanoSeconds());
        System.out.println("* " + "optimized instantiation average processing time in nanoseconds:   " + optimized.getAvgProcessTimeInNanoSeconds());
        System.out.println("* " + "overall speed improvement in nanoseconds:                " + (unOptimized.getAvgProcessTimeInNanoSeconds() - optimized.getAvgProcessTimeInNanoSeconds()));
        System.out.println("*".repeat(200));
        System.out.println();
    }
}
