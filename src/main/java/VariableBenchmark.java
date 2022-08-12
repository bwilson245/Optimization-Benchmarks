import java.lang.management.GarbageCollectorMXBean;

public class VariableBenchmark extends Benchmark {

    public VariableBenchmark(int totalCalls, int iterationCount) {
        super(totalCalls, iterationCount);
    }

    public void IntegerTest() {
        int i;
        for (i = 0; i++ < totalCalls - 1; ) {
            long time = System.nanoTime();
            int j;
            for (j = 0; j++ < iterationCount - 1; ) {
                Integer test = 1;
            }
            add(System.nanoTime() - time);
        }
        calculate();
    }

    public void intTest() {
        int i;
        for (i = 0; i++ < totalCalls - 1; ) {
            long time = System.nanoTime();
            int j;
            for (j = 0; j++ < iterationCount - 1; ) {
                int test = 1;
            }
            add(System.nanoTime() - time);
        }
        calculate();
    }

    public void DoubleTest() {
        int i;
        for (i = 0; i++ < totalCalls - 1; ) {
            long time = System.nanoTime();
            int j;
            for (j = 0; j++ < iterationCount - 1; ) {
                Double test = 1.0;
            }
            add(System.nanoTime() - time);
        }
        calculate();
    }

    public void doubleTest() {
        int i;
        for (i = 0; i++ < totalCalls - 1; ) {
            long time = System.nanoTime();
            int j;
            for (j = 0; j++ < iterationCount - 1; ) {
                double test = 1.0;
            }
            add(System.nanoTime() - time);
        }
        calculate();
    }

    public void LongTest() {
        int i;
        for (i = 0; i++ < totalCalls - 1; ) {
            long time = System.nanoTime();
            int j;
            for (j = 0; j++ < iterationCount - 1; ) {
                Long test = 1L;
            }
            add(System.nanoTime() - time);
        }
        calculate();
    }

    public void longTest() {
        int i;
        for (i = 0; i++ < totalCalls - 1; ) {
            long time = System.nanoTime();
            int j;
            for (j = 0; j++ < iterationCount - 1; ) {
                long test = 1L;
            }
            add(System.nanoTime() - time);
        }
        calculate();
    }

    public void FloatTest() {
        int i;
        for (i = 0; i++ < totalCalls - 1; ) {
            long time = System.nanoTime();
            int j;
            for (j = 0; j++ < iterationCount - 1; ) {
                Float test = 1.0f;
            }
            add(System.nanoTime() - time);
        }
        calculate();
    }

    public void floatTest() {
        int i;
        for (i = 0; i++ < totalCalls - 1; ) {
            long time = System.nanoTime();
            int j;
            for (j = 0; j++ < iterationCount - 1; ) {
                float test = 1.0f;
            }
            add(System.nanoTime() - time);
        }
        calculate();
    }

    public void CharacterTest() {
        int i;
        for (i = 0; i++ < totalCalls - 1; ) {
            long time = System.nanoTime();
            int j;
            for (j = 0; j++ < iterationCount - 1; ) {
                Character test = 'a';
            }
            add(System.nanoTime() - time);
        }
        calculate();
    }

    public void charTest() {
        int i;
        for (i = 0; i++ < totalCalls - 1; ) {
            long time = System.nanoTime();
            int j;
            for (j = 0; j++ < iterationCount - 1; ) {
                char test = 'a';
            }
            add(System.nanoTime() - time);
        }
        calculate();
    }
}
