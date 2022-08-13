import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        System.out.println("* " + "Wrapper average processing time:     " + unOptimizedInteger.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("* " + "Primitive average processing time:   " + optimizedInt.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("-".repeat(100));
        System.out.println("* " + "overall speed improvement:           " + (unOptimizedInteger.getAvgProcessTimeInNanoSeconds() - optimizedInt.getAvgProcessTimeInNanoSeconds()) + " nanoseconds");
        System.out.println("*".repeat(100));
        System.out.println();

        System.out.println("*".repeat(100));
        System.out.println("* ---------- VariableBenchmark Long Test Results ----------");
        System.out.println("* " + "Wrapper average processing time:     " + unOptimizedLong.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("* " + "Primitive average processing time:   " + optimizedLong.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("-".repeat(100));
        System.out.println("* " + "overall speed improvement:           " + (unOptimizedLong.getAvgProcessTimeInNanoSeconds() - optimizedLong.getAvgProcessTimeInNanoSeconds()) + " nanoseconds");
        System.out.println("*".repeat(100));
        System.out.println();

        System.out.println("*".repeat(100));
        System.out.println("* ---------- VariableBenchmark Float Test Results ----------");
        System.out.println("* " + "Wrapper average processing time:     " + unOptimizedFloat.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("* " + "Primitive average processing time:   " + optimizedFloat.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("-".repeat(100));
        System.out.println("* " + "overall speed improvement:           " + (unOptimizedFloat.getAvgProcessTimeInNanoSeconds() - optimizedFloat.getAvgProcessTimeInNanoSeconds()) + " nanoseconds");
        System.out.println("*".repeat(100));
        System.out.println();

        System.out.println("*".repeat(100));
        System.out.println("* ---------- VariableBenchmark Double Test Results ----------");
        System.out.println("* " + "Wrapper average processing time:     " + unOptimizedDouble.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("* " + "Primitive average processing time:   " + optimizedDouble.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("-".repeat(100));
        System.out.println("* " + "overall speed improvement:           " + (unOptimizedDouble.getAvgProcessTimeInNanoSeconds() - optimizedDouble.getAvgProcessTimeInNanoSeconds()) + " nanoseconds");
        System.out.println("*".repeat(100));
        System.out.println();

        System.out.println("*".repeat(100));
        System.out.println("* ---------- VariableBenchmark Character Test Results ----------");
        System.out.println("* " + "Wrapper average processing time:     " + unOptimizedCharacter.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("* " + "Primitive average processing time:   " + optimizedChar.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("-".repeat(100));
        System.out.println("* " + "overall speed improvement:           " + (unOptimizedCharacter.getAvgProcessTimeInNanoSeconds() - optimizedChar.getAvgProcessTimeInNanoSeconds()) + " nanoseconds");
        System.out.println("*".repeat(100));
        System.out.println();
    }
}
