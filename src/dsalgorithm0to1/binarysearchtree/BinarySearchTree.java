package dsalgorithm0to1.binarysearchtree;

import dsalgorithm0to1.binarytree.BinaryTree;
import dsalgorithm0to1.queue.QueueImpl;

/**
 * Created by rakeshgupta on 10/18/16.
 */
public class BinarySearchTree {
    public static void main(String[] args)
            throws QueueImpl.QueueUnderflowException,
            QueueImpl.QueueOverflowException {

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

        System.out.println("Binary Search Tree(BST) traversing...");
        System.out.print("Breadth First Search : [ ");
        BinaryTree.breadthFirst(bSTRoot);
        System.out.print("]");


    }

    public static BinaryTree.Node insertData(BinaryTree.Node head,
                                            BinaryTree.Node node){

        if (head == null)
            return node;

        if ((int)node.getData() <= (int)head.getData())
            head.setLeftChild(insertData(head.getLeftChild(), node));
        else
            head.setRightChild(insertData(head.getRightChild(), node));

        return head;
    }
}
