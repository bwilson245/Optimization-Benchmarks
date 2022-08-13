package utility;

import java.util.*;

public class Node {
    public int value;
    public Node left, right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public static Node build(int low, int high) {
        int mid = low + (high - low) / 2;
        Node node;
        if (low < high) {
            node = new Node(mid);
            node.left = build(low, mid - 1);
            node.right = build(mid + 1, high);
        } else {
            return null;
        }
        return node;
    }

    @Override
    public String toString(){
        String result = "[";
        Queue<Node> q = new LinkedList<>();
        q.add(this);
        Node node = null;
        while (!q.isEmpty()) {
            node = q.poll();
            result += "" + node.value + ", ";
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
        result = result.substring(0, result.length() - 2);
        result += "]";
        return result;
    }
}
