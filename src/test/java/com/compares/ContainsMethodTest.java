package com.compares;

import com.methods.ContainsMethod;
import com.OptimizationsInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContainsMethodTest implements OptimizationsInterface {
    int totalCalls = 20;
    int totalIterations = 10000;
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
        ContainsMethod lowTarget = new ContainsMethod(totalCalls, totalIterations, low);
        ContainsMethod highTarget = new ContainsMethod(totalCalls, totalIterations, high);

        //WHEN
        lowTarget.execute("listContains");
        highTarget.execute("listContains");

        long listTimesLowTarget = lowTarget.getAvgProcessTimeInNanoSeconds();
        long listTimesHighTarget = highTarget.getAvgProcessTimeInNanoSeconds();

        lowTarget.clearData();
        highTarget.clearData();

        lowTarget.execute("setContains");
        highTarget.execute("setContains");

        long setTimesLowTarget = lowTarget.getAvgProcessTimeInNanoSeconds();
        long setTimesHighTarget = highTarget.getAvgProcessTimeInNanoSeconds();

        lowTarget.clearData();
        highTarget.clearData();

        lowTarget.execute("queueContains");
        highTarget.execute("queueContains");

        long queueTimesLowTarget = lowTarget.getAvgProcessTimeInNanoSeconds();
        long queueTimesHighTarget = highTarget.getAvgProcessTimeInNanoSeconds();

        lowTarget.clearData();
        highTarget.clearData();

        lowTarget.execute("stackContains");
        highTarget.execute("stackContains");

        long stackTimesLowTarget = lowTarget.getAvgProcessTimeInNanoSeconds();
        long stackTimesHighTarget = highTarget.getAvgProcessTimeInNanoSeconds();

        //THEN
        Assertions.assertTrue(listTimesLowTarget < listTimesHighTarget);
        Assertions.assertTrue(setTimesLowTarget < setTimesHighTarget);
        Assertions.assertTrue(queueTimesLowTarget < queueTimesHighTarget);
        Assertions.assertTrue(stackTimesLowTarget < stackTimesHighTarget);

        long longestTimeLow = Math.max(Math.max(listTimesLowTarget, setTimesLowTarget), Math.max(queueTimesLowTarget, stackTimesLowTarget));
        long shortestTimeLow = Math.min(Math.min(listTimesLowTarget, setTimesLowTarget), Math.min(queueTimesLowTarget, stackTimesLowTarget));
        long longestTimeHigh = Math.max(Math.max(listTimesHighTarget, setTimesHighTarget), Math.max(queueTimesHighTarget, stackTimesHighTarget));
        long shortestTimeHigh = Math.min(Math.min(listTimesHighTarget, setTimesHighTarget), Math.min(queueTimesHighTarget, stackTimesHighTarget));

        String longestProcessLow = longestTimeLow == listTimesLowTarget ? "LIST" : longestTimeLow == setTimesLowTarget ? "SET" : longestTimeLow == queueTimesLowTarget ? "QUEUE" : "STACK";
        String shortestProcessLow = shortestTimeLow == listTimesLowTarget ? "LIST" : shortestTimeLow == setTimesLowTarget ? "SET" : shortestTimeLow == queueTimesLowTarget ? "QUEUE" : "STACK";
        String longestProcessHigh = longestTimeHigh == listTimesHighTarget ? "LIST" : longestTimeHigh == setTimesHighTarget ? "SET" : longestTimeHigh == queueTimesHighTarget ? "QUEUE" : "STACK";
        String shortestProcessHigh = shortestTimeHigh == listTimesHighTarget ? "LIST" : shortestTimeHigh == setTimesHighTarget ? "SET" : shortestTimeHigh == queueTimesHighTarget ? "QUEUE" : "STACK";

        System.out.println("#".repeat(100));
        System.out.println("# ---------- ContainsMethod LowTarget Test Results ----------");
        System.out.println("# LIST average processing time:    " + listTimesLowTarget + " nanoseconds");
        System.out.println("# SET average processing time:     " + setTimesLowTarget + " nanoseconds");
        System.out.println("# QUEUE average processing time:   " + queueTimesLowTarget + " nanoseconds");
        System.out.println("# STACK average processing time:   " + stackTimesLowTarget + " nanoseconds");
        System.out.println("# " + "-".repeat(100));
        System.out.println("# " + longestProcessLow + " had the longest processing time");
        System.out.println("# " + shortestProcessLow + " had the shortest processing time");
        System.out.println("# overall speed improvement:       " + (longestTimeLow - shortestTimeLow) + " nanoseconds");
        System.out.println("#".repeat(100));
        System.out.println();

        System.out.println("#".repeat(100));
        System.out.println("# ---------- ContainsMethod HighTarget Test Results ----------");
        System.out.println("# LIST average processing time:    " + listTimesHighTarget + " nanoseconds");
        System.out.println("# SET average processing time:     " + setTimesHighTarget + " nanoseconds");
        System.out.println("# QUEUE average processing time:   " + queueTimesHighTarget + " nanoseconds");
        System.out.println("# STACK average processing time:   " + stackTimesHighTarget + " nanoseconds");
        System.out.println("# " + "-".repeat(100));
        System.out.println("# " + longestProcessHigh + " had the longest processing time");
        System.out.println("# " + shortestProcessHigh + " had the shortest processing time");
        System.out.println("# overall speed improvement:       " + (longestTimeHigh - shortestTimeHigh) + " nanoseconds");
        System.out.println("#".repeat(100));
        System.out.println();


        System.out.println("#".repeat(100));
        System.out.println("# ---------- ContainsMethod Individual Statistics ----------");
        System.out.println("# LIST lowTarget time is faster than highTarget time by:    " + (listTimesHighTarget - listTimesLowTarget) + " nanoseconds");
        System.out.println("# SET lowTarget time is faster than highTarget time by:     " + (setTimesHighTarget - setTimesLowTarget) + " nanoseconds");
        System.out.println("# QUEUE lowTarget time is faster than highTarget time by:   " + (queueTimesHighTarget - queueTimesLowTarget) + " nanoseconds");
        System.out.println("# STACK lowTarget time is faster than highTarget time by:   " + (stackTimesHighTarget - stackTimesLowTarget) + " nanoseconds");
        System.out.println("#".repeat(100));
        System.out.println();
    }
}
