package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrder {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeData.getRandomPopulatedData();
        printLevelOrderTraversal(binaryTree);
    }

    private static void printLevelOrderTraversal(BinaryTree binaryTree) {
        if (binaryTree == null)
            return;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(binaryTree.data);
        while (!queue.isEmpty()) {
            Integer data = queue.poll();
            System.out.printf("%d     ", data);
            if (binaryTree.left != null)
                printLevelOrderTraversal(binaryTree.left);
            if (binaryTree.right != null)
                printLevelOrderTraversal(binaryTree.right);
        }
    }
}
