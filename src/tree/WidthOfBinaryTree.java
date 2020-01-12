package tree;

/**
 * Created by rakeshgupta on 4/2/17.
 */
public class WidthOfBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeData.getPopulatedData();
        System.out.println("Width of Binary Tree : " + widthOfBinaryTree(binaryTree));
    }

    public static int widthOfBinaryTree(BinaryTree root) {
        int max = 0;
        int height = HeightOfBinaryTree.heightOfBinaryTree(root);
        for (int i = 0; i <= height ; i++){
            int tmp = widthOfBinaryTree(root, i);
            if (tmp > max)
                max = tmp;
        }
        return max;
        }

    public static int widthOfBinaryTree(BinaryTree root, int depth) {
        if (root == null) return 0;
        if (depth == 0) return 1;
        return widthOfBinaryTree(root.left, depth + 1) + widthOfBinaryTree(root.right, depth - 1);
    }
}
