package treeoperation;

import tree.BinaryTree;
import tree.BinaryTreeData;

/**
 * Created by : Rakesh Gupta on 8/19/17
 * Package : treeoperation
 */
public class CheckBalanceTree {
    public static void main(String[] args) {
        BinaryTree root = BinaryTreeData.GetPopulatedData();

        boolean status = checkBalanceTree(root);
        System.out.println("Checking if tree is balance : " + status);
    }

    private static boolean checkBalanceTree(BinaryTree root) {
        return (maxDepth(root)-minDepth(root) <= 1);
    }

    private static int minDepth(BinaryTree root) {
        if (root == null)
            return 0;
        return (1 + Math.min(minDepth(root.getLeft()), minDepth(root.getRight())));
    }

    private static int maxDepth(BinaryTree root) {
        if (root == null)
            return 0;
        return (1 + Math.max(maxDepth(root.getLeft()), maxDepth(root.getRight())));
    }
}
