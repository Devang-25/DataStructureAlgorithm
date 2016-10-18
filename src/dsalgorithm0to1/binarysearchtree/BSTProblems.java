package dsalgorithm0to1.binarysearchtree;

import dsalgorithm0to1.binarytree.BinaryTree;

import static dsalgorithm0to1.binarytree.BinaryTree.inOrder;

/**
 * Created by rakeshgupta on 10/19/16.
 */
public class BSTProblems {

    public static void main(String[] args) {
        BinaryTree.Node bSTRoot = new BinaryTree.Node(10);
        BinaryTree.Node leftChild = new BinaryTree.Node(9);
        BinaryTree.Node rightChild = new BinaryTree.Node(11);

        bSTRoot.setLeftChild(leftChild);
        bSTRoot.setRightChild(rightChild);

        BinaryTree.Node leftChild4 = new BinaryTree.Node(4);
        BinaryTree.Node rightChild15 = new BinaryTree.Node(15);

        leftChild.setLeftChild(leftChild4);
        rightChild.setRightChild(rightChild15);

        leftChild4.setLeftChild(new BinaryTree.Node(3));
        leftChild4.setRightChild(new BinaryTree.Node(6));

        rightChild15.setLeftChild(new BinaryTree.Node(14));
        rightChild15.setRightChild(new BinaryTree.Node(18));

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

    public static int minValue(BinaryTree.Node root){
        if (root == null)
            return -1;

        if (root.getLeftChild() == null)
            return ((int) root.getData());

        return minValue(root.getLeftChild());
    }
}
