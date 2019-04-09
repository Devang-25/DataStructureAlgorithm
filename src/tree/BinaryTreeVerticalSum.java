package tree;

import java.util.TreeMap;

public class BinaryTreeVerticalSum {
    private static TreeMap<Integer, Integer> map = new TreeMap<>();

    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeData.getRandomPopulatedData();
        BinaryTree.preOrder(binaryTree);
        printVertivalSumOfBinaryTree(binaryTree, map, 0);
        System.out.println(map);
    }

    private static void printVertivalSumOfBinaryTree(BinaryTree binaryTree, TreeMap<Integer, Integer> treeMap, int level) {
        if (binaryTree == null)
            return;

        printVertivalSumOfBinaryTree(binaryTree.left, treeMap, level - 1);
        if (treeMap.get(level) != null) {
            Integer data = treeMap.get(level) + binaryTree.data;
            treeMap.put(level, data);
        } else {
            treeMap.put(level, binaryTree.data);
        }
        printVertivalSumOfBinaryTree(binaryTree.right, treeMap, level + 1);
    }
}
