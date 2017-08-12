package tree;

/**
 * Created by : Rakesh Gupta on 8/13/17
 * Package : tree
 */
public class CheckingBalanceBST {
    public static void main(String[] args) {
        BinaryTree root = BinaryTreeData.GetPopulatedData();

        boolean check = isBalanceBinaryTree(root);
        System.out.println("Checking if tree is balance binary tree : " + check);
    }

    private static boolean isBalanceBinaryTree(BinaryTree root) {
        if (root == null)
            return true;

        boolean leftTree = isBalanceBinaryTree(root.left);
        boolean rightTree = isBalanceBinaryTree(root.right);
        if (!leftTree && !rightTree)
            return false;
        return true;
    }
}
