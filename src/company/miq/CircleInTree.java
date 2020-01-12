package company.miq;

import tree.BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class CircleInTree {

    public static void main(String[] args) {

    }

    static int[] solve(int[][] edges, int N) {
        int[] ans = new int[2];
        BinaryTree binaryTree = null;
        Map<Integer, Integer> dp = new HashMap<>();
        return ans;
    }

    static void updateDepth(Node node, int depth, Map<Integer, Integer> map) {
        if (node != null) {
            map.put(node.data, depth);
            updateDepth(node.left, depth + 1, map); // left sub-tree
            updateDepth(node.right, depth + 1, map); // right sub-tree
        }
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int value) {
            this.data = value;
        }
    }
}
