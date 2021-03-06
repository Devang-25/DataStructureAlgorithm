package binarysearchtree;

import tree.binarytree.BinaryTree;

import static tree.binarytree.BinaryTree.inOrder;

/**
 * Created by rakeshgupta on 10/19/16.
 */
public class BSTProblems {

    public static void main(String[] args) {
        BinaryTree.Node bSTRoot = BinarySearchTree.getBSTDataPopulatedTree();

        System.out.println();
        System.out.println("*******Finding minimum in Binary Search Tree*********");
        int minimumValue = minValue(bSTRoot);
        if (minimumValue != -1)
            System.out.println("Min value in BST is: " + minimumValue);
        System.out.println();
        System.out.println("*******Max Depth of BST***********");
        int depth = depthOfBST(bSTRoot);
        System.out.println("Depth of BST is: " + depth);

        System.out.println();
        System.out.println("**********Mirror a BST********");
        mirrorBST(bSTRoot);
        System.out.println("BST after mirroring tree: ");
        inOrder(bSTRoot);
        System.out.println();
        System.out.println("***Counting number of Structurally Unique possible tree***");
        System.out.println(countTrees(3));
        System.out.println();
        System.out.println("***Printing node if it is within range***");
        printRange(bSTRoot, 4, 17);
        System.out.println();
        System.out.println("***Checking a tree if it is Binary Search Tree***");
        System.out.println(isBinarySearchTree(bSTRoot, 3, 11));
        System.out.println();


    }


    private static boolean isBinarySearchTree(BinaryTree.Node root, int min, int max) {
        if (root == null)
            return true;

        if (((int) root.getData()) <= min || ((int) root.getData()) > max)
            return false;

        return isBinarySearchTree(root.getLeftChild(), min, ((int) root.getData()))
                && isBinarySearchTree(root.getRightChild(), ((int) root.getData()), max);
    }

    private static void printRange(BinaryTree.Node root, int low, int high) {
        if (root == null)
            return;
        if (low <= (int) root.getData())
            printRange(root.getLeftChild(), low, high);
        if (low <= ((int) root.getData()) && ((int) root.getData()) <= high)
            System.out.println(root.getData());

        if (high > ((int) root.getData()))
            printRange(root.getRightChild(), low, high);
    }

    private static int countTrees(int numNodes) {
        if (numNodes <= 1)
            return 1;

        int sum = 0;
        for (int i = 1; i <= numNodes; i++) {
            int countLeftTrees = countTrees(i - 1);
            int countRightTrees = countTrees(numNodes - 1);

            sum = sum + (countLeftTrees * countRightTrees);
        }
        return sum;
    }

    private static void mirrorBST(BinaryTree.Node bSTRoot) {
        if (bSTRoot == null)
            return;

        mirrorBST(bSTRoot.getLeftChild());
        mirrorBST(bSTRoot.getRightChild());

        BinaryTree.Node temp = bSTRoot.getLeftChild();
        bSTRoot.setLeftChild(bSTRoot.getRightChild());
        bSTRoot.setRightChild(temp);
    }

    private static int depthOfBST(BinaryTree.Node bSTRoot) {
        if (bSTRoot == null)
            return 0;
        int leftMaxDepth = 1 + depthOfBST(bSTRoot.getLeftChild());
        int rightMaxDepth = 1 + depthOfBST(bSTRoot.getRightChild());

        return Math.max(leftMaxDepth, rightMaxDepth);
    }

    public static int minValue(BinaryTree.Node root) {
        if (root == null)
            return -1;

        if (root.getLeftChild() == null)
            return ((int) root.getData());

        return minValue(root.getLeftChild());
    }
}
