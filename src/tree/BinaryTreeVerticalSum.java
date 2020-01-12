package tree;

import leetcode.hash.BinaryTreeVerticalOrderTraversal;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BinaryTreeVerticalSum {
    private static TreeMap<Integer, Integer> map = new TreeMap<>();

    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeData.getRandomPopulatedData();
        BinaryTree.printTree(binaryTree);
        System.out.println();
        printVerticalSumOfBinaryTree(binaryTree, map, 0);
        System.out.println(map);
        Map<Integer, List<Integer>> mm = new TreeMap<>();
        BinaryTreeVerticalOrderTraversal.printVerticalOrder(binaryTree, mm, 0);
        System.out.println(mm);
    }

    private static void printVerticalSumOfBinaryTree(BinaryTree root, TreeMap<Integer, Integer> treeMap, int level) {
        if (root == null)
            return;

        printVerticalSumOfBinaryTree(root.left, treeMap, level - 1);
        if (treeMap.get(level) != null) {
            Integer data = treeMap.get(level) + root.data;
            treeMap.put(level, data);
        } else {
            treeMap.put(level, root.data);
        }
        printVerticalSumOfBinaryTree(root.right, treeMap, level + 1);
    }
}
