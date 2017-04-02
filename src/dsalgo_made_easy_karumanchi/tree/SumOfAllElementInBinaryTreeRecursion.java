package dsalgo_made_easy_karumanchi.tree;

/**
 * Created by rakeshgupta on 4/2/17.
 */
public class SumOfAllElementInBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeData.GetPopulatedData();
        System.out.println("Sum of all element in Binary tree : " + sumOfAllElementInBinarytree(binaryTree));
    }

    private static int sumOfAllElementInBinarytree(BinaryTree root) {
        if (root == null )
            return 0;
        else
        return root.getData() + sumOfAllElementInBinarytree(root.left) + sumOfAllElementInBinarytree(root.right);
    }
}
