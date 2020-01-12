package tree;


/**
 * Created by rakeshgupta on 4/2/17.
 */
public class SumOfAllElementInBinaryTreeRecursion {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeData.getPopulatedData();
        BinaryTree.printTree(binaryTree);
        System.out.println("Sum of all element in Binary tree : " + sumOfAllElementInBinarytree(binaryTree));
    }

    private static int sumOfAllElementInBinarytree(BinaryTree root) {
        if (root == null )
            return 0;
        return root.getData() + sumOfAllElementInBinarytree(root.left) + sumOfAllElementInBinarytree(root.right);
    }
}
