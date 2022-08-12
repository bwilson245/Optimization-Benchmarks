public class LoopBenchmark extends Benchmark{

    public LoopBenchmark(int totalCalls, int iterationCount) {
        super(totalCalls, iterationCount);
    }

    public void unOptimizedTest() {
        for (int i = 0; i < totalCalls; i++) {
            long time = System.nanoTime();
            for (int j = 0; j < iterationCount; j++) {
                String res;
                if (j % 3 == 0) {
                    res = "*".repeat(200);
                } else {
                    res = "!".repeat(50);
                }
            }
            add(System.nanoTime() - time);
        }
        calculate();
    }

    public void optimizedTest() {
        int i;
        for (i = 0; i++ < totalCalls - 1; ) {
            long time = System.nanoTime();
            int j;
            for (j = 0; j++ < iterationCount - 1; ) {
                String res;
                if (j % 3 == 0) {
                    res = "*".repeat(200);
                } else {
                    res = "!".repeat(50);
                }
            }
            add(System.nanoTime() - time);
        }
        calculate();
    }
}
