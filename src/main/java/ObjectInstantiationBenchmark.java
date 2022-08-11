public class ObjectInstantiationBenchmark extends Benchmark{
    public ObjectInstantiationBenchmark(int totalCalls, int iterationCount) {
        super(totalCalls, iterationCount);
    }

    public void unOptimizedInstantiation(){
        for (int i = 0; i < totalCalls; i++) {
            long time = System.nanoTime();
            int j;
            for (j = 0; j++ < iterationCount; ) {
                StringBuilder builder = new StringBuilder();
                builder.append("TEST".repeat(20));
            }
            processTimes.add(System.nanoTime() - time);
        }
        calculate();
    }

    public void optimizedInstantiation(){
        for (int i = 0; i < totalCalls; i++) {
            long time = System.nanoTime();
            StringBuilder builder = new StringBuilder();
            int j;
            for (j = 0; j++ < iterationCount; ) {
                builder.setLength(0);
                builder.append("TEST".repeat(20));
            }
            processTimes.add(System.nanoTime() - time);
        }
        calculate();
    }
}
