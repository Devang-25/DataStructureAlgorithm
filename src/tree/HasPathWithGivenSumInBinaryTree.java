package tree;

/**
 * Created by rakeshgupta on 4/2/17.
 */
public class HasPathWithGivenSumInBinaryTree {
    public static void main(String[] args) {
        BinaryTree root = BinaryTreeData.getPopulatedData();
        BinaryTree.printTree(root);
        System.out.println("BinaryTree has path of  8 : " + hasPathSum(root, 8));
    }

    private static boolean hasPathSum(BinaryTree root, int sum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null && root.data == sum)
            return true;
        return hasPathSum(root.left, sum-root.getData()) || hasPathSum(root.right, sum-root.getData());
    }
}
