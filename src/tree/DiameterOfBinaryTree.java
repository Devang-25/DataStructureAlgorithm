package tree;

import static tree.BinaryTree.BTreePrinter.printNode;

/** Created by rakeshgupta on 4/2/17. */

public class DiameterOfBinaryTree {
    public static void main(String[] args) {

        BinaryTree binaryTree = BinaryTreeData.getPopulatedData();
        printNode(binaryTree);
        System.out.println("Diameter of Binary tree : " + diameterOfBTree(binaryTree, new Height()));
    }

    private static int diameterOfBTree(BinaryTree root, Height height) {
        if (root == null) {
            height.h = 0;
            return 0;
        }
        Height lh = new Height(), rh = new Height();
        int diameterOfLeft = diameterOfBTree(root.left, lh);
        int diameterOfRight = diameterOfBTree(root.right, rh);
        height.h = Math.max(lh.h, rh.h) + 1;
        int maxHeightUsingRoot = lh.h + rh.h + 1;
        int maxHeightFromChild = Math.max(diameterOfLeft, diameterOfRight);
        return Math.max(maxHeightUsingRoot, maxHeightFromChild);
    }

    static class Height {
        int h;
    }
}
