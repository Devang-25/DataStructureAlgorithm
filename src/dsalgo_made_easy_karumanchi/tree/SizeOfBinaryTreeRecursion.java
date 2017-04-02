package dsalgo_made_easy_karumanchi.tree;

/**
 * Created by rakeshgupta on 4/2/17.
 */
public class SizeOfBinaryTreeRecursion {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeData.GetPopulatedData();
        System.out.println("Size of tree : " + sizeOfTree(binaryTree));
    }

    private static int sizeOfTree(BinaryTree root) {
            int leftSize = root.left==null ? 0 : sizeOfTree(root.left);
            int rightSize = root.right == null ? 0 : sizeOfTree(root.right);

            return 1 + leftSize + rightSize;
    }

}
