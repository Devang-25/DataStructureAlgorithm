package binarysearchtree;

import tree.BinaryTree;

/**
 * Created by rakeshgupta on 10/18/16.
 */
public class BinarySearchTree {
    private static int minDiffKey;
    private static int minDiff;

    public static void maxDiffUtil(BinaryTree ptr, int k) {
        if (ptr == null)
            return;

        if (ptr.getData() == k) {
            minDiffKey = k;
            return;
        }
        if (minDiff > Math.abs(ptr.getData() - k)) {
            minDiff = Math.abs(ptr.getData() - k);
            minDiffKey = ptr.getData();
        }
        if (k < ptr.getData())
            maxDiffUtil(ptr.left, k);
        else
            maxDiffUtil(ptr.right, k);
    }

    public boolean isBST(tree.BinaryTree root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTUtil(tree.BinaryTree node, int min, int max) {
        if (node == null)
            return true;

        if (node.getData() < min || node.getData() > max)
            return false;

        return (isBSTUtil(node.left, min, node.getData() - 1) && isBSTUtil(node.right, node.getData() + 1, max));
    }
}
