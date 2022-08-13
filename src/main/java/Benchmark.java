import java.util.ArrayList;
import java.util.List;

public abstract class Benchmark {
    private List<Long> processTimes;
    private long avgProcessTimeInNanoSeconds;
    protected int totalCalls;
    protected int iterationCount;

    public Benchmark(int totalCalls, int iterationCount) {
        this.totalCalls = totalCalls;
        this.iterationCount = iterationCount;
        this.processTimes = new ArrayList<>();
        this.avgProcessTimeInNanoSeconds = 0;
    }
    public void calculate() {
        long sum = 0;
        for (Long l : processTimes) {
            sum += l;
        }
        if (processTimes.size() > 0) {
            this.avgProcessTimeInNanoSeconds = sum / this.processTimes.size();
        }
    }

    public void add(long time) {
        processTimes.add(time);
        System.gc();
    }


    public long getAvgProcessTimeInNanoSeconds() {
        return avgProcessTimeInNanoSeconds;
    }
}
