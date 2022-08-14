package com.optimizations;

import com.Optimizations;
import com.utility.MemoryTester;
import com.utility.Node;

import java.util.*;

public class BinaryTreeOptimizations extends Optimizations {
    private Node node;
    private int target;
    private List<Double> memoryUsed;
    private double memUsed;
    private String memType;
    private double avgMemoryUsed;

    public BinaryTreeOptimizations(int totalCalls, int iterationCount, int target, String memType) {
        super(totalCalls, iterationCount);
        this.node = Node.build(0, iterationCount);
        this.target = target;
        this.memUsed = 0;
        this.memType = memType;
        this.memoryUsed = new ArrayList<>();
        this.avgMemoryUsed = 0.0;
    }

    public void execute(String method) {
        memoryUsed.clear();
        for (int i = 0; i < totalCalls; i++) {
            System.gc();
            switch (method) {
                case "depthFirstIterativeSearchTIME": {
                    addTime(depthFirstIterativeSearchTIME());
                    break;
                }
                case "breadthFirstIterativeSearchTIME": {
                    addTime(breadthFirstIterativeSearchTIME());
                    break;
                }
                case "depthFirstRecursiveSearchTIME": {
                    addTime(depthFirstRecursiveSearchTIME());
                    break;
                }
                case "depthFirstIterativeSearchMEMORY": {
                    addMemory(depthFirstIterativeSearchMEMORY());
                    break;
                }
                case "breadthFirstIterativeSearchMEMORY": {
                    addMemory(breadthFirstIterativeSearchMEMORY());
                    break;
                }
                case "depthFirstRecursiveSearchMEMORY": {
                    addMemory(depthFirstRecursiveSearchMEMORY());
                    break;
                }
                default:
            }
        }
        calculateAverageTime();
        calculateAverageMemory();
    }

    public void calculateAverageMemory() {
        Double sum = 0.0;
        for (Double d : memoryUsed) {
            sum += d;
        }
        this.avgMemoryUsed = sum / this.memoryUsed.size();
    }

    public void addMemory(double memory) {
        memoryUsed.add(memory);
        System.gc();
    }

    public double getAvgMemoryUsedInKb() { return avgMemoryUsed; }

    @Override
    public String toString() {
        String result = "[";
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(node);
        Node node = null;
        while (!nodes.isEmpty()) {
            node = nodes.poll();
            result  += "" + node.value + ", ";
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        result = result.substring(0, result.length() - 2);
        result += "]";
        return result;
    }

    public long depthFirstIterativeSearchTIME() {
        long time = System.nanoTime();
        Stack<Node> nodes = new Stack<>();
        if (node != null) {
            nodes.push(node);
        }
        Node node = null;
        while (!nodes.isEmpty()) {
            node = nodes.pop();
            if (node.value == target) {
                break;
            }
            if (node.left != null) {
                nodes.push(node.left);
            }
            if (node.right != null) {
                nodes.push(node.right);
            }
        }
        if (node == null || node.value != target) {
            throw new RuntimeException("Not Found");
        }
        return System.nanoTime() - time;
    }

    public long breadthFirstIterativeSearchTIME() {
        long time = System.nanoTime();
        Queue<Node> nodes = new LinkedList<>();
        if (node != null) {
            nodes.add(node);
        }
        Node node = null;
        while (!nodes.isEmpty()) {
            node = nodes.poll();
            if (node.value == target) {
                break;
            }
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        addMemory(System.nanoTime() - time);
        if (node == null || node.value != target) {
            throw new RuntimeException("Not Found");
        }
        return System.nanoTime() - time;
    }

    public long depthFirstRecursiveSearchTIME() {
        long time = System.nanoTime();
        boolean found = recursiveSearchDepthFirstTIME(node);
        if (!found) {
            throw new RuntimeException("Not Found");
        }
        return System.nanoTime() - time;
    }

    private boolean recursiveSearchDepthFirstTIME(Node node) {
        if (node == null) {
            return false;
        }
        if (node.value == target) {
            return true;
        }

        boolean left = recursiveSearchDepthFirstTIME(node.left);
        boolean right = recursiveSearchDepthFirstTIME(node.right);

        return left || right;
    }


    public double depthFirstIterativeSearchMEMORY() {
        memUsed = MemoryTester.getUsedMemory(memType);
        Stack<Node> nodes = new Stack<>();
        if (node != null) {
            nodes.push(node);
        }
        Node node = null;
        while (!nodes.isEmpty()) {
            node = nodes.pop();
            if (node.value == target) {
                break;
            }
            if (node.left != null) {
                nodes.push(node.left);
            }
            if (node.right != null) {
                nodes.push(node.right);
            }
        }
        if (node == null || node.value != target) {
            throw new RuntimeException("Not Found");
        }
        return MemoryTester.getUsedMemory(memType) - memUsed;
    }

    public double breadthFirstIterativeSearchMEMORY() {
        memUsed = MemoryTester.getUsedMemory(memType);
        Queue<Node> nodes = new LinkedList<>();
        if (node != null) {
            nodes.add(node);
        }
        Node node = null;
        while (!nodes.isEmpty()) {
            node = nodes.poll();
            if (node.value == target) {
                break;
            }
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        if (node == null || node.value != target) {
            throw new RuntimeException("Not Found");
        }
        return MemoryTester.getUsedMemory(memType) - memUsed;
    }

    public double depthFirstRecursiveSearchMEMORY() {
        memUsed = MemoryTester.getUsedMemory(memType);
        boolean found = recursiveSearchDepthFirstMEMORY(node);
        if (!found) {
            throw new RuntimeException("Not Found");
        }
        return memUsed;
    }

    private boolean recursiveSearchDepthFirstMEMORY(Node node) {
        if (node == null) {
            memUsed = Math.max(memUsed,MemoryTester.getUsedMemory(memType));
            return false;
        }
        if (node.value == target) {
            memUsed = Math.max(memUsed,MemoryTester.getUsedMemory(memType));
            return true;
        }

        boolean left = recursiveSearchDepthFirstMEMORY(node.left);
        boolean right = recursiveSearchDepthFirstMEMORY(node.right);

        memUsed = Math.max(memUsed,MemoryTester.getUsedMemory(memType));
        return left || right;
    }
}
