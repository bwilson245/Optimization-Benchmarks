import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConcurrencyOptimizationsTest implements TestInterface {
    int totalCalls = 100;
    int totalIterations = 100;

    @Test
    public void run() {
        //GIVEN
        ConcurrencyOptimizations unOptimized = new ConcurrencyOptimizations(totalCalls, totalIterations);
        ConcurrencyOptimizations optimized = new ConcurrencyOptimizations(totalCalls, totalIterations);

        //WHEN
        unOptimized.unOptimizedTest();
        optimized.optimizedTest();;

        //THEN
        Assertions.assertTrue(unOptimized.getAvgProcessTimeInNanoSeconds() > optimized.getAvgProcessTimeInNanoSeconds());

        System.out.println("*".repeat(100));
        System.out.println("* ---------- ConcurrencyOptimizations Test Results ----------");
        System.out.println("* " + "unOptimized average processing time: " + unOptimized.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("* " + "optimized average processing time:   " + optimized.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("-".repeat(100));
        System.out.println("* " + "overall speed improvement:           " + (unOptimized.getAvgProcessTimeInNanoSeconds() - optimized.getAvgProcessTimeInNanoSeconds()) + " nanoseconds");
        System.out.println("*".repeat(100));
        System.out.println();
    }
}
