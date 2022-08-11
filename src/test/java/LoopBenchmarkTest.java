import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoopBenchmarkTest {
    int totalCalls = 200;
    int totalIterations = 1000000;

    @Test
    public void forLoop_equalValues_OptimizedIsFaster() {
        //GIVEN
        LoopBenchmark unOptimized = new LoopBenchmark(totalCalls, totalIterations);
        LoopBenchmark optimized = new LoopBenchmark(totalCalls, totalIterations);

        //WHEN
        unOptimized.unOptimizedLoop();
        optimized.optimizedLoop();

        //THEN
        Assertions.assertTrue(unOptimized.getAvgProcessTimeInNanoSeconds() > optimized.getAvgProcessTimeInNanoSeconds());

        System.out.println("*".repeat(200));
        System.out.println("* " + "unOptimized loop average processing time in nanoseconds: " + unOptimized.getAvgProcessTimeInNanoSeconds());
        System.out.println("* " + "optimized loop average processing time in nanoseconds:   " + optimized.getAvgProcessTimeInNanoSeconds());
        System.out.println("* " + "overall speed improvement in nanoseconds:                " + (unOptimized.getAvgProcessTimeInNanoSeconds() - optimized.getAvgProcessTimeInNanoSeconds()));
        System.out.println("*".repeat(200));
        System.out.println();
    }
}
