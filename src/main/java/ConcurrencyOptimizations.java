import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrencyOptimizations extends Optimizations {
    public ConcurrencyOptimizations(int totalCalls, int iterationCount) {
        super(totalCalls, iterationCount);
    }

    public void unOptimizedTest() {
        int i;
        for (i = -1; i++ < totalCalls - 1; ) {
            long time = System.nanoTime();
            int j;
            for (j = -1; j++ < iterationCount - 1; ) {
                simulatedLoad();
            }
            add(System.nanoTime() - time);
        }
        calculate();
    }

    public void optimizedTest() {
        ExecutorService service;
        int i;
        for (i = -1; i++ < totalCalls - 1; ) {
            long time = System.nanoTime();
            service = Executors.newCachedThreadPool();
            int j;
            for (j = -1; j++ < iterationCount - 1; ) {
                service.submit(this::simulatedLoad);
            }
            service.shutdown();
            try {
                service.awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {}
            add(System.nanoTime() - time);
        }

        calculate();
    }

    public void simulatedLoad() {
        int i;
        for (i = 0; i++ < 9999; ) {
            StringBuilder a = new StringBuilder("SIMULATED LOAD");
        }
    }
}
