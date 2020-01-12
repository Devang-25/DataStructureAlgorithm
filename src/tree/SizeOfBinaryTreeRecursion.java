package tree;


/**
 * Created by rakeshgupta on 4/2/17.
 */
public class SizeOfBinaryTreeRecursion {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeData.getPopulatedData();
        BinaryTree.printTree(binaryTree);
        System.out.println("Size of tree : " + sizeOfTree(binaryTree));
        System.out.println("Size of tree : " + treeSize(binaryTree));
    }

    private static int sizeOfTree(BinaryTree root) {
            int leftSize = (root.left == null) ? 0 : sizeOfTree(root.left);
            int rightSize = root.right == null ? 0 : sizeOfTree(root.right);

            return 1 + leftSize + rightSize;
    }

    private static int treeSize(BinaryTree root){
        if (root == null) return 0;
        return 1 + treeSize(root.left) + treeSize(root.right);
    }
}
