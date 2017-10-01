package tree;

import java.util.Arrays;

/**
 * Created by : Rakesh Gupta on 8/13/17
 * Package : tree
 */
public class ConvertBinaryTreeToBST {
    public static void main(String[] args) {
        BinaryTree root = BinaryTreeData.GetPopulatedData();
        System.out.println("Binary Tree traversal :  ");
        BinaryTree.inOrder(root);
        System.out.println("\nBinary Search tree traversal of Binary Tree after conversion from Binary Tree to BST:  ");
        changeTreeToBST(root);
        BinaryTree.inOrder(root);
    }

    private static void changeTreeToBST(BinaryTree root) {
        int[] inorder = new int[7];
        int[] index = new int[1];

        createInOrderArray(root, inorder, index);

        Arrays.sort(inorder);

        index[0] = 0;

        changeNodeValue(root, inorder, index);
    }

    private static void changeNodeValue(BinaryTree root, int[] inorder, int[] index) {
        if (root == null)
            return;
        changeNodeValue(root.left, inorder, index);
        root.data = inorder[index[0]];
        index[0] += 1;
        changeNodeValue(root.right, inorder, index);
    }

    private static void createInOrderArray(BinaryTree root, int[] inorder, int[] index) {
        if (root == null)
            return;
        createInOrderArray(root.left, inorder, index);
        inorder[index[0]] = root.getData();
        index[0] += 1;
        createInOrderArray(root.right, inorder, index);
    }
}
