package tree;


/**
 * Created by rakeshgupta on 4/2/17.
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeData.GetPopulatedData();
        System.out.println("Diameter of Binary tree : " + diameterOfBinaryTree(binaryTree));
    }

    private static int diameterOfBinaryTree(BinaryTree root) {
        int left, right, diameter = 0;
        if (root == null)
            return 0;
        left = diameterOfBinaryTree(root.left);
        right = diameterOfBinaryTree(root.right);
        if (left + right > diameter)
            diameter = left+right;
        return Math.max(left, right)+1;
    }
}
