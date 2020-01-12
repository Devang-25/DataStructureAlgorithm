package tree;

public class RemoveHalfNodeBST {
    public static void main(String[] args) {
    BinaryTree root = BinaryTreeData.getBinaryTreeRandomData();
    BinaryTree.printTree(root);
    BinaryTree.printTree(removeHalfNodeBST(root));
    }

    public static BinaryTree removeHalfNodeBST(BinaryTree root) {
        if (root == null) return null;

        root.left = removeHalfNodeBST(root.getLeft());
        root.right = removeHalfNodeBST(root.getRight());

        if (root.getLeft() == null && root.getRight() == null)
            return root;

        if (root.getLeft() == null)
            return root.getRight();

        if (root.getRight() == null)
            return root.getLeft();

        return root;
    }
}
