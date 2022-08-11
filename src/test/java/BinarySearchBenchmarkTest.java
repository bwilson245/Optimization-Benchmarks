import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchBenchmarkTest {
    int totalCalls = 200;
    int totalIterations = 1000000;
    int target = totalIterations - 1;

    @Test
    public void search_sameValues_optimizedIsFaster() {
        //GIVEN
        BinarySearchBenchmark unOptimized = new BinarySearchBenchmark(totalCalls, totalIterations, target);
        BinarySearchBenchmark optimized = new BinarySearchBenchmark(totalCalls, totalIterations, target);

        //WHEN
        unOptimized.unOptimizedSearch();
        optimized.optimizedSearch();

        System.out.println(unOptimized.getAvgProcessTimeInNanoSeconds());
        System.out.println(optimized.getAvgProcessTimeInNanoSeconds());

        //THEN
        Assertions.assertTrue(unOptimized.getAvgProcessTimeInNanoSeconds() > optimized.getAvgProcessTimeInNanoSeconds());

        System.out.println("*".repeat(200));
        System.out.println("* " + "unOptimized search average processing time in nanoseconds: " + unOptimized.getAvgProcessTimeInNanoSeconds());
        System.out.println("* " + "optimized search average processing time in nanoseconds:   " + optimized.getAvgProcessTimeInNanoSeconds());
        System.out.println("* " + "overall speed improvement in nanoseconds:                  " + (unOptimized.getAvgProcessTimeInNanoSeconds() - optimized.getAvgProcessTimeInNanoSeconds()));
        System.out.println("*".repeat(200));
        System.out.println();
    }

}
