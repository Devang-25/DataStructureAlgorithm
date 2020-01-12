package tree;

import static java.lang.Math.*;

/**
 * Created by rakeshgupta on 4/2/17.
 */
public class MaxElementInBinaryTreeRecursion {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeData.getPopulatedData();
        BinaryTree.printTree(binaryTree);
        System.out.println(maxInBinaryTree(binaryTree));
    }

    public static int maxInBinaryTree(BinaryTree root){
        if (root != null ){
            int leftMax = maxInBinaryTree(root.getLeft());
            int rightMax = maxInBinaryTree(root.getRight());
            return max(root.getData(), max(leftMax, rightMax));
        }
        return Integer.MIN_VALUE;
    }
}
