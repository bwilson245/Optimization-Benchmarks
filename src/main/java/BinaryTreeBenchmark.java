import utility.MemoryTester;
import utility.Node;

import java.util.*;

public class BinaryTreeBenchmark extends Benchmark{
    private Node node;
    private int target;
    private List<Double> memoryUsed;
    private double memUsed;
    private String memType;
    private double avgMemoryUsed;

    public BinaryTreeBenchmark(int totalCalls, int iterationCount, int target, String memType) {
        super(totalCalls, iterationCount);
        this.node = Node.build(0, iterationCount);
        this.target = target;
        this.memUsed = 0;
        this.memType = memType;
        this.memoryUsed = new ArrayList<>();
        this.avgMemoryUsed = 0.0;
    }

    public void calculateAverageMemory() {
        Double sum = 0.0;
        for (Double d : memoryUsed) {
            sum += d;
        }
        this.avgMemoryUsed = sum / this.memoryUsed.size();
    }

    public void add(double memory) {
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

    public void depthFirstIterativeSearchTIME() {
        int i;
        for (i = -1; i++ < totalCalls - 1; ) {
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
            add(System.nanoTime() - time);
            if (node == null || node.value != target) {
                throw new RuntimeException("Not Found");
            }
        }
        calculate();
    }

    public void breadthFirstIterativeSearchTIME() {
        int i;
        for (i = -1; i++ < totalCalls - 1; ) {
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
            add(System.nanoTime() - time);
            if (node == null || node.value != target) {
                throw new RuntimeException("Not Found");
            }
        }
        calculate();
    }

    public void depthFirstRecursiveSearchTIME() {
        int i;
        for (i = -1; i++ < totalCalls - 1; ) {
            long time = System.nanoTime();
            boolean found = recursiveSearchDepthFirstTIME(node);
            if (!found) {
                throw new RuntimeException("Not Found");
            }
            add(System.nanoTime() - time);
        }
        calculate();
    }

    public void breadthFirstRecursiveSearchTIME() {
        int i;
        for (i = -1; i++ < totalCalls - 1; ) {
            long time = System.nanoTime();
            boolean found = recursiveSearchBreadthFirstTIME(node);
            if (!found) {
                throw new RuntimeException("Not Found");
            }
            add(System.nanoTime() - time);
        }
        calculate();
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

    private boolean recursiveSearchBreadthFirstTIME(Node node) {
        if (node == null) {
            return false;
        }
        if (node.value == target) {
            return true;
        }

        if (target < node.value) {
            return recursiveSearchBreadthFirstTIME(node.left);
        } else {
            return recursiveSearchBreadthFirstTIME(node.right);
        }
    }


    public void depthFirstIterativeSearchMEMORY() {
        int i;
        for (i = -1; i++ < totalCalls - 1; ) {
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
            add(MemoryTester.getUsedMemory(memType) - memUsed);
        }
        calculateAverageMemory();
    }

    public void breadthFirstIterativeSearchMEMORY() {
        int i;
        for (i = -1; i++ < totalCalls - 1; ) {
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
            add(MemoryTester.getUsedMemory(memType) - memUsed);
        }
        calculateAverageMemory();
    }

    public void depthFirstRecursiveSearchMEMORY() {
        int i;
        for (i = -1; i++ < totalCalls - 1; ) {
            memUsed = MemoryTester.getUsedMemory(memType);
            boolean found = recursiveSearchDepthFirstMEMORY(node);
            if (!found) {
                throw new RuntimeException("Not Found");
            }
            add(memUsed);
        }
        calculateAverageMemory();
    }

    public void breadthFirstRecursiveSearchMEMORY() {
        int i;
        for (i = -1; i++ < totalCalls - 1; ) {
            memUsed = MemoryTester.getUsedMemory(memType);
            boolean found = recursiveSearchBreadthFirstMEMORY(node);
            if (!found) {
                throw new RuntimeException("Not Found");
            }
            add(memUsed);
        }
        calculateAverageMemory();
    }

    private boolean recursiveSearchDepthFirstMEMORY(Node node) {
        double currentMem = MemoryTester.getUsedMemory(memType);
        if (node == null) {
            memUsed = Math.max(memUsed,MemoryTester.getUsedMemory(memType) - currentMem);
            return false;
        }
        if (node.value == target) {
            memUsed = Math.max(memUsed,MemoryTester.getUsedMemory(memType) - currentMem);
            return true;
        }

        boolean left = recursiveSearchDepthFirstMEMORY(node.left);
        boolean right = recursiveSearchDepthFirstMEMORY(node.right);

        memUsed = Math.max(memUsed,MemoryTester.getUsedMemory(memType) - currentMem);
        return left || right;
    }

    private boolean recursiveSearchBreadthFirstMEMORY(Node node) {
        double currentMem = MemoryTester.getUsedMemory(memType);
        if (node == null) {
            memUsed = Math.max(memUsed, MemoryTester.getUsedMemory(memType) - currentMem);
            return false;
        }
        if (node.value == target) {
            memUsed = Math.max(memUsed,MemoryTester.getUsedMemory(memType) - currentMem);
            return true;
        }
        if (target < node.value) {
            memUsed = Math.max(memUsed,MemoryTester.getUsedMemory(memType) - currentMem);
            return recursiveSearchBreadthFirstMEMORY(node.left);
        } else {
            memUsed = Math.max(memUsed,MemoryTester.getUsedMemory(memType) - currentMem);
            return recursiveSearchBreadthFirstMEMORY(node.right);
        }
    }
}
