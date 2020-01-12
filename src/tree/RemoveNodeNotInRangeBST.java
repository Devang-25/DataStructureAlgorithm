package tree;

public class RemoveNodeNotInRangeBST {
    public static void main(String[] args) {
        BinaryTree root = BinaryTreeData.getBinaryTreeRandomData();
        BinaryTree.printTree(root);
        BinaryTree.printTree(removeNodeNotInRangeBST(root, 0, 6));
    }

    private static BinaryTree removeNodeNotInRangeBST(BinaryTree root, int k1, int k2) {
        if (root == null) return null;

        root.left = removeNodeNotInRangeBST(root.getLeft(), k1, k2);
        root.right = removeNodeNotInRangeBST(root.getRight(), k1, k2);

        if (root.getData() >= k1 && root.getData() <= k2)
            return root;

        if (root.getData() < k1)
            return root.getRight();

        if (root.getData() > k2)
            return root.getLeft();

        return null;
    }
}
