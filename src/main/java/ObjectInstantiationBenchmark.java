public class ObjectInstantiationBenchmark extends Benchmark{
    public ObjectInstantiationBenchmark(int totalCalls, int iterationCount) {
        super(totalCalls, iterationCount);
    }

    public void unOptimizedTest(){
        int i;
        for (i = -1; i++ < totalCalls - 1; ) {
            long time = System.nanoTime();
            int j;
            for (j = -1; j++ < iterationCount - 1; ) {
                StringBuilder builder = new StringBuilder();
                builder.append("TEST".repeat(20));
            }
            add(System.nanoTime() - time);
        }
        calculate();
    }

    public void optimizedTest(){
        int i;
        for (i = -1; i++ < totalCalls - 1; ) {
            long time = System.nanoTime();
            StringBuilder builder = new StringBuilder();
            int j;
            for (j = -1; j++ < iterationCount - 1; ) {
                builder.setLength(0);
                builder.append("TEST".repeat(20));
            }
            add(System.nanoTime() - time);
        }
        calculate();
    }
}
