package tree;


/**
 * Created by rakeshgupta on 4/2/17.
 */
public class HeightOfBinaryTreeRecursion {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeData.GetPopulatedData();
        System.out.println("Height of Binary Tree : " + heightOfBinaryTree(binaryTree));
    }

    public static int heightOfBinaryTree(BinaryTree root) {
        if (root == null )
            return 0;

        int leftHeight = heightOfBinaryTree(root.left);
        int rightHeight = heightOfBinaryTree(root.right);
        return (leftHeight > rightHeight) ? leftHeight+1 : rightHeight+1;

    }
}
