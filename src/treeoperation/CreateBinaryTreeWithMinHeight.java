package treeoperation;

import tree.BinaryTree;

import java.util.stream.IntStream;

/**
 * Created by : Rakesh Gupta on 8/19/17
 * Package : treeoperation
 */
public class CreateBinaryTreeWithMinHeight {
    public static void main(String[] args) {
        int arr[] = IntStream.range(3, 10).toArray();
       // Arrays.sort(arr);
        System.out.println("Creating Binary Tree with minimal height :");
        BinaryTree root = createBinaryTree(arr);
      //  BinaryTree.inOrder(root);
        BinaryTree.printTree(root);
    }

    private static BinaryTree createBinaryTree(int[] arr) {
        return addToBinaryTree(arr, 0, arr.length-1);
    }

    private static BinaryTree addToBinaryTree(int[] arr, int start, int end) {

        if (end < start)
            return null;

        int mid = (start+end)/2;
        BinaryTree root = new BinaryTree(arr[mid]);
        root.left = addToBinaryTree(arr, start, mid-1);
        root.right = addToBinaryTree(arr, mid+1, end);
        return root;
    }
}
