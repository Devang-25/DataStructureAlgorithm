package tree;

public class RemoveLeavesNodeBST {

    public static void main(String[] args) {
        BinaryTree root = BinaryTreeData.getBinaryTreeRandomData();
        BinaryTree.printTree(root);
        BinaryTree.printTree(removeLeavesNodeBST(root));
    }

    public static BinaryTree removeLeavesNodeBST(BinaryTree root) {
        if (root == null)
            return null;

        if (root.getLeft() == null && root.getRight() == null) {
            return null;
        } else {
            root.left = removeLeavesNodeBST(root.getLeft());
            root.right = removeLeavesNodeBST(root.getRight());
        }
        return root;
    }
}
