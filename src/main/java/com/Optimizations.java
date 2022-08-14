package com;

import java.util.ArrayList;
import java.util.List;

public abstract class Optimizations {
    protected List<Long> processTimes;
    protected long avgProcessTimeInNanoSeconds;
    protected int totalCalls;
    protected int iterationCount;

    public Optimizations(int totalCalls, int iterationCount) {
        this.totalCalls = totalCalls;
        this.iterationCount = iterationCount;
        this.processTimes = new ArrayList<>();
        this.avgProcessTimeInNanoSeconds = 0;
    }
    public void calculateAverageTime() {
        long sum = 0;
        for (Long l : processTimes) {
            sum += l;
        }
        if (processTimes.size() > 0) {
            this.avgProcessTimeInNanoSeconds = sum / this.processTimes.size();
        }
    }

    public void addTime(Long time) {
        processTimes.add(time);
        System.gc();
    }


    public long getAvgProcessTimeInNanoSeconds() {
        return avgProcessTimeInNanoSeconds;
    }

    public void clearData() {
        this.processTimes = new ArrayList<>();
        this.avgProcessTimeInNanoSeconds = 0;
    }
}
