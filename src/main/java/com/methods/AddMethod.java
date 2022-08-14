package com.methods;

import com.Optimizations;

import java.util.*;

public class AddMethod extends Optimizations {
    private Set<Integer> set;
    private List<Integer> list;
    private Queue<Integer> queue;
    private Stack<Integer> stack;
    private int target;

    public AddMethod(int totalCalls, int iterationCount, int target) {
        super(totalCalls, iterationCount);
        this.set = new HashSet<>();
        this.list = new ArrayList<>();
        this.queue = new LinkedList<>();
        this.stack = new Stack<>();
        this.target = target;
    }

    public void execute(String method) {
        for (int i = 0; i < totalCalls; i++) {
            System.gc();
            switch (method) {
                case "setAdd": {
                    addTime(setAdd());
                    break;
                }
                case "listAdd": {
                    addTime(listAdd());
                    break;
                }
                case "queueAdd": {
                    addTime(queueAdd());
                    break;
                }
                case "stackAdd": {
                    addTime(stackAdd());
                    break;
                }
                default:
            }
        }
        calculateAverageTime();
    }

    public long setAdd() {
        long time = System.nanoTime();
        for (int i = 0; i < iterationCount; i++) {
            set.add(i);
        }
        return System.nanoTime() - time;
    }

    public long listAdd() {
        long time = System.nanoTime();
        for (int i = 0; i < iterationCount; i++) {
            list.add(i);
        }
        return System.nanoTime() - time;
    }

    public long queueAdd() {
        long time = System.nanoTime();
        for (int i = 0; i < iterationCount; i++) {
            queue.add(i);
        }
        return System.nanoTime() - time;
    }

    public long stackAdd() {
        long time = System.nanoTime();
        for (int i = 0; i < iterationCount; i++) {
            stack.add(i);
        }
        return System.nanoTime() - time;
    }

    private Set<Integer> buildSet() {
        Set<Integer> set = new HashSet<>();
        int i;
        for (i = 0; i < iterationCount; i++) {
            if (i != target) {
                set.add(i);
            }
        }
        return set;
    }
    private List<Integer> buildList() {
        List<Integer> list = new ArrayList<>();
        int i;
        for (i = 0; i < iterationCount; i++) {
            if (i != target) {
                list.add(i);
            }
        }
        return list;
    }
    private Queue<Integer> buildQueue() {
        Queue<Integer> queue = new LinkedList<>();
        int i;
        for (i = 0; i < iterationCount; i++) {
            if (i != target) {
                queue.add(i);
            }
        }
        return queue;
    }
    private Stack<Integer> buildStack() {
        Stack<Integer> stack = new Stack<>();
        int i;
        for (i = 0; i < iterationCount; i++) {
            if (i != target) {
                stack.push(i);
            }
        }
        return stack;
    }
}
