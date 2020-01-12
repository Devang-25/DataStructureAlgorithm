package tree;

/**
 * Created by rakeshgupta on 4/2/17.
 */
public class CheckStructurallyIdenticalInBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeData.getPopulatedData();
        BinaryTree binaryTree1 = new BinaryTree(99);
        System.out.println("Checking if two Binary tree is structually Identical : " + checkStructurallyBinaryTree(binaryTree, binaryTree1));
    }

    public static boolean checkStructurallyBinaryTree(BinaryTree root1, BinaryTree root2 ) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return checkStructurallyBinaryTree(root1.getLeft(), root2.getRight()) && checkStructurallyBinaryTree(root1.getRight(), root2.getLeft());
    }
}
