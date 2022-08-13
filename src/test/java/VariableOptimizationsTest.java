import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VariableOptimizationsTest implements TestInterface {
    int totalCalls = 100;
    int totalIterations = 1000;

    @Test
    public void run() {
        //GIVEN
        VariableOptimizations unOptimizedInteger = new VariableOptimizations(totalCalls, totalIterations);
        VariableOptimizations optimizedInt = new VariableOptimizations(totalCalls, totalIterations);
        VariableOptimizations unOptimizedLong = new VariableOptimizations(totalCalls, totalIterations);
        VariableOptimizations optimizedLong = new VariableOptimizations(totalCalls, totalIterations);
        VariableOptimizations unOptimizedFloat = new VariableOptimizations(totalCalls, totalIterations);
        VariableOptimizations optimizedFloat = new VariableOptimizations(totalCalls, totalIterations);
        VariableOptimizations unOptimizedDouble = new VariableOptimizations(totalCalls, totalIterations);
        VariableOptimizations optimizedDouble = new VariableOptimizations(totalCalls, totalIterations);
        VariableOptimizations unOptimizedCharacter = new VariableOptimizations(totalCalls, totalIterations);
        VariableOptimizations optimizedChar = new VariableOptimizations(totalCalls, totalIterations);

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
        System.out.println("* ---------- VariableOptimizations Integer Test Results ----------");
        System.out.println("* " + "Wrapper average processing time:     " + unOptimizedInteger.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("* " + "Primitive average processing time:   " + optimizedInt.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("-".repeat(100));
        System.out.println("* " + "overall speed improvement:           " + (unOptimizedInteger.getAvgProcessTimeInNanoSeconds() - optimizedInt.getAvgProcessTimeInNanoSeconds()) + " nanoseconds");
        System.out.println("*".repeat(100));
        System.out.println();

        System.out.println("*".repeat(100));
        System.out.println("* ---------- VariableOptimizations Long Test Results ----------");
        System.out.println("* " + "Wrapper average processing time:     " + unOptimizedLong.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("* " + "Primitive average processing time:   " + optimizedLong.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("-".repeat(100));
        System.out.println("* " + "overall speed improvement:           " + (unOptimizedLong.getAvgProcessTimeInNanoSeconds() - optimizedLong.getAvgProcessTimeInNanoSeconds()) + " nanoseconds");
        System.out.println("*".repeat(100));
        System.out.println();

        System.out.println("*".repeat(100));
        System.out.println("* ---------- VariableOptimizations Float Test Results ----------");
        System.out.println("* " + "Wrapper average processing time:     " + unOptimizedFloat.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("* " + "Primitive average processing time:   " + optimizedFloat.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("-".repeat(100));
        System.out.println("* " + "overall speed improvement:           " + (unOptimizedFloat.getAvgProcessTimeInNanoSeconds() - optimizedFloat.getAvgProcessTimeInNanoSeconds()) + " nanoseconds");
        System.out.println("*".repeat(100));
        System.out.println();

        System.out.println("*".repeat(100));
        System.out.println("* ---------- VariableOptimizations Double Test Results ----------");
        System.out.println("* " + "Wrapper average processing time:     " + unOptimizedDouble.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("* " + "Primitive average processing time:   " + optimizedDouble.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("-".repeat(100));
        System.out.println("* " + "overall speed improvement:           " + (unOptimizedDouble.getAvgProcessTimeInNanoSeconds() - optimizedDouble.getAvgProcessTimeInNanoSeconds()) + " nanoseconds");
        System.out.println("*".repeat(100));
        System.out.println();

        System.out.println("*".repeat(100));
        System.out.println("* ---------- VariableOptimizations Character Test Results ----------");
        System.out.println("* " + "Wrapper average processing time:     " + unOptimizedCharacter.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("* " + "Primitive average processing time:   " + optimizedChar.getAvgProcessTimeInNanoSeconds() + " nanoseconds");
        System.out.println("-".repeat(100));
        System.out.println("* " + "overall speed improvement:           " + (unOptimizedCharacter.getAvgProcessTimeInNanoSeconds() - optimizedChar.getAvgProcessTimeInNanoSeconds()) + " nanoseconds");
        System.out.println("*".repeat(100));
        System.out.println();
    }
}
