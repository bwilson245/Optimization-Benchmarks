import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;

public class VariableBenchmarkTest implements TestInterface {
    int totalCalls = 100;
    int totalIterations = 1000;

    @Test
    public void run() {
        //GIVEN
        VariableBenchmark unOptimizedInteger = new VariableBenchmark(totalCalls, totalIterations);
        VariableBenchmark optimizedInt = new VariableBenchmark(totalCalls, totalIterations);
        VariableBenchmark unOptimizedLong = new VariableBenchmark(totalCalls, totalIterations);
        VariableBenchmark optimizedLong = new VariableBenchmark(totalCalls, totalIterations);
        VariableBenchmark unOptimizedFloat = new VariableBenchmark(totalCalls, totalIterations);
        VariableBenchmark optimizedFloat = new VariableBenchmark(totalCalls, totalIterations);
        VariableBenchmark unOptimizedDouble = new VariableBenchmark(totalCalls, totalIterations);
        VariableBenchmark optimizedDouble = new VariableBenchmark(totalCalls, totalIterations);
        VariableBenchmark unOptimizedCharacter = new VariableBenchmark(totalCalls, totalIterations);
        VariableBenchmark optimizedChar = new VariableBenchmark(totalCalls, totalIterations);

        //WHEN
        unOptimizedInteger.IntegerTest();
        optimizedInt.intTest();
        unOptimizedLong.LongTest();
        optimizedLong.longTest();
        unOptimizedFloat.FloatTest();
        optimizedFloat.floatTest();
        unOptimizedDouble.DoubleTest();
        optimizedDouble.doubleTest();
        unOptimizedCharacter.CharacterTest();
        optimizedChar.charTest();

        //THEN
        Assertions.assertTrue(unOptimizedInteger.getAvgProcessTimeInNanoSeconds() > optimizedInt.getAvgProcessTimeInNanoSeconds());
        Assertions.assertTrue(unOptimizedLong.getAvgProcessTimeInNanoSeconds() > optimizedLong.getAvgProcessTimeInNanoSeconds());
        Assertions.assertTrue(unOptimizedFloat.getAvgProcessTimeInNanoSeconds() > optimizedFloat.getAvgProcessTimeInNanoSeconds());
        Assertions.assertTrue(unOptimizedDouble.getAvgProcessTimeInNanoSeconds() > optimizedDouble.getAvgProcessTimeInNanoSeconds());
        Assertions.assertTrue(unOptimizedCharacter.getAvgProcessTimeInNanoSeconds() > optimizedChar.getAvgProcessTimeInNanoSeconds());

        System.out.println("*".repeat(100));
        System.out.println("* ---------- VariableBenchmark Integer Test Results ----------");
        System.out.println("* " + "unOptimized average processing time in nanoseconds: " + unOptimizedInteger.getAvgProcessTimeInNanoSeconds());
        System.out.println("* " + "optimized average processing time in nanoseconds:   " + optimizedInt.getAvgProcessTimeInNanoSeconds());
        System.out.println("* " + "overall speed improvement in nanoseconds:           " + (unOptimizedInteger.getAvgProcessTimeInNanoSeconds() - optimizedInt.getAvgProcessTimeInNanoSeconds()));
        System.out.println("*".repeat(100));
        System.out.println();

        System.out.println("*".repeat(100));
        System.out.println("* ---------- VariableBenchmark Long Test Results ----------");
        System.out.println("* " + "unOptimized average processing time in nanoseconds: " + unOptimizedLong.getAvgProcessTimeInNanoSeconds());
        System.out.println("* " + "optimized average processing time in nanoseconds:   " + optimizedLong.getAvgProcessTimeInNanoSeconds());
        System.out.println("* " + "overall speed improvement in nanoseconds:           " + (unOptimizedLong.getAvgProcessTimeInNanoSeconds() - optimizedLong.getAvgProcessTimeInNanoSeconds()));
        System.out.println("*".repeat(100));
        System.out.println();

        System.out.println("*".repeat(100));
        System.out.println("* ---------- VariableBenchmark Float Test Results ----------");
        System.out.println("* " + "unOptimized average processing time in nanoseconds: " + unOptimizedFloat.getAvgProcessTimeInNanoSeconds());
        System.out.println("* " + "optimized average processing time in nanoseconds:   " + optimizedFloat.getAvgProcessTimeInNanoSeconds());
        System.out.println("* " + "overall speed improvement in nanoseconds:           " + (unOptimizedFloat.getAvgProcessTimeInNanoSeconds() - optimizedFloat.getAvgProcessTimeInNanoSeconds()));
        System.out.println("*".repeat(100));
        System.out.println();

        System.out.println("*".repeat(100));
        System.out.println("* ---------- VariableBenchmark Double Test Results ----------");
        System.out.println("* " + "unOptimized average processing time in nanoseconds: " + unOptimizedDouble.getAvgProcessTimeInNanoSeconds());
        System.out.println("* " + "optimized average processing time in nanoseconds:   " + optimizedDouble.getAvgProcessTimeInNanoSeconds());
        System.out.println("* " + "overall speed improvement in nanoseconds:           " + (unOptimizedDouble.getAvgProcessTimeInNanoSeconds() - optimizedDouble.getAvgProcessTimeInNanoSeconds()));
        System.out.println("*".repeat(100));
        System.out.println();

        System.out.println("*".repeat(100));
        System.out.println("* ---------- VariableBenchmark Character Test Results ----------");
        System.out.println("* " + "unOptimized average processing time in nanoseconds: " + unOptimizedCharacter.getAvgProcessTimeInNanoSeconds());
        System.out.println("* " + "optimized average processing time in nanoseconds:   " + optimizedChar.getAvgProcessTimeInNanoSeconds());
        System.out.println("* " + "overall speed improvement in nanoseconds:           " + (unOptimizedCharacter.getAvgProcessTimeInNanoSeconds() - optimizedChar.getAvgProcessTimeInNanoSeconds()));
        System.out.println("*".repeat(100));
        System.out.println();
    }
}
