package tree;

/**
 * Created by : Rakesh Gupta on 8/13/17
 * Package : tree
 */
public class CheckingBalanceBST {
    public static void main(String[] args) {
        BinaryTree root = BinaryTreeData.GetPopulatedData();
        BinaryTree.printTree(root);
        BinaryTree.deleteNode(root, 7);
        BinaryTree.deleteNode(root, 3);
        BinaryTree.deleteNode(root, 6);
        BinaryTree.printTree(root);
        //boolean check = isBalanceBinaryTree(root);
        //System.out.println("Checking if tree is balance binary tree : " + check);
        boolean isBST = checkBalance(root) != -1 ? true : false;
        System.out.println("Checking if tree is balance binary tree :  " + isBST);
    }

    private static boolean isBalanceBinaryTree(BinaryTree root) {
        if (root == null)
            return true;
        return isBalanceBinaryTree(root.left) || isBalanceBinaryTree(root.right);
    }

    private static int checkBalance(BinaryTree currentNode) {
        if (currentNode == null) {
            return 0;
        }
        int leftSubtreeHeight = checkBalance(currentNode.left);
        if (leftSubtreeHeight == -1) return -1;

        int rightSubtreeHeight = checkBalance(currentNode.right);
        if (rightSubtreeHeight == -1) return -1;

        if (Math.abs(leftSubtreeHeight - rightSubtreeHeight) > 1) {
            return -1;
        }
        return (Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1);
    }

}
