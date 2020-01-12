package tree;


/**
 * Created by rakeshgupta on 4/2/17.
 */
public class HeightOfBinaryTreeRecursion {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeData.getPopulatedData();
        BinaryTree.printTree(binaryTree);
        System.out.println("Height of Binary Tree : " + heightOfBinaryTree(binaryTree));
    }

    public static int heightOfBinaryTree(BinaryTree root) {
        if (root == null )
            return 0;

        int leftHeight = heightOfBinaryTree(root.left);
        int rightHeight = heightOfBinaryTree(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
