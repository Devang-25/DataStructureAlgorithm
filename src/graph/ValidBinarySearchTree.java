package graph;


/* implement a function to check if a binary tree is a binary search tree */

public class ValidBinarySearchTree {
    boolean checkBST(TreeNode n) {
        return checkBST(n, null, null);
    }

    boolean checkBST(TreeNode n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }
        if ((min != null && n.val <= min) || (max != null && n.val > max)) {
            return false;
        }

        if (!checkBST(n.left, min, n.val) || !checkBST(n.right, n.val, max)) {
            return false;
        }
        return true;
    }

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
