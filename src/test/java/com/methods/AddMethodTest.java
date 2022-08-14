package com.methods;

import com.OptimizationsInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddMethodTest implements OptimizationsInterface {
    int totalCalls = 100;
    int totalIterations = 1000;
    int low = 1;
    int high = totalIterations - 1;

    @BeforeEach
    public void setup() throws InterruptedException {
        System.gc();
        Thread.sleep(100);
    }

    @Test
    public void run() {
        //GIVEN
        AddMethod addMethod = new AddMethod(totalCalls, totalIterations, low);

        //WHEN
        addMethod.execute("listAdd");
        long listTimes = addMethod.getAvgProcessTimeInNanoSeconds();
        addMethod.clearData();

        addMethod.execute("setAdd");
        long setTimes = addMethod.getAvgProcessTimeInNanoSeconds();
        addMethod.clearData();

        addMethod.execute("queueAdd");
        long queueTimes = addMethod.getAvgProcessTimeInNanoSeconds();
        addMethod.clearData();

        addMethod.execute("stackAdd");
        long stackTimes = addMethod.getAvgProcessTimeInNanoSeconds();

        //THEN
        Assertions.assertTrue(listTimes < Math.max(setTimes, Math.max(queueTimes, stackTimes)));
        Assertions.assertTrue(setTimes > Math.min(listTimes, Math.min(queueTimes, stackTimes)));

        long longestTimeLow = Math.max(Math.max(listTimes, setTimes), Math.max(queueTimes, stackTimes));
        long shortestTimeLow = Math.min(Math.min(listTimes, setTimes), Math.min(queueTimes, stackTimes));

        String longestProcessLow = longestTimeLow == listTimes ? "LIST" : longestTimeLow == setTimes ? "SET" : longestTimeLow == queueTimes ? "QUEUE" : "STACK";
        String shortestProcessLow = shortestTimeLow == listTimes ? "LIST" : shortestTimeLow == setTimes ? "SET" : shortestTimeLow == queueTimes ? "QUEUE" : "STACK";

        System.out.println("#".repeat(100));
        System.out.println("# ---------- AddMethod Test Results ----------");
        System.out.println("# LIST average processing time:    " + listTimes + " nanoseconds");
        System.out.println("# SET average processing time:     " + setTimes + " nanoseconds");
        System.out.println("# QUEUE average processing time:   " + queueTimes + " nanoseconds");
        System.out.println("# STACK average processing time:   " + stackTimes + " nanoseconds");
        System.out.println("# " + "-".repeat(100));
        System.out.println("# " + longestProcessLow + " had the longest processing time");
        System.out.println("# " + shortestProcessLow + " had the shortest processing time");
        System.out.println("# overall speed improvement:       " + (longestTimeLow - shortestTimeLow) + " nanoseconds");
        System.out.println("#".repeat(100));
        System.out.println();
    }
}
