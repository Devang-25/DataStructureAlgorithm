package tree;

/**
 * Created by rakeshgupta on 4/2/17.
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeData.GetPopulatedData();
        BinaryTree.BTreePrinter.printNode(binaryTree);

        System.out.println("Diameter of Binary tree : " + diameterOfBTree(binaryTree, new Height()));
    }

    private static int diameterOfBTree(BinaryTree root, Height height) {

        Height lh = new Height(), rh = new Height();

        if (root == null) {
            height.h = 0;
            return 0;
        }

        int diameterOfLeft = diameterOfBTree(root.left, lh);
        int diameterOfRight = diameterOfBTree(root.right, rh);
        height.h = Math.max(lh.h, rh.h) + 1;

        return Math.max(lh.h + rh.h + 1, Math.max(diameterOfLeft, diameterOfRight));
    }

    static class Height {
        int h;
    }
}
