package tree;

/**
 * Created by rakeshgupta on 4/2/17.
 */
public class MakeMirrorOfBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeData.GetPopulatedData();

        BinaryTree node = makeMirrorOfBinaryTree(binaryTree);

        System.out.println("New Mirror is identical or not : " + CheckStructurallyIdenticalInBinaryTree.checkStructurallyBinaryTree(binaryTree, node));
    }

    private static BinaryTree makeMirrorOfBinaryTree(BinaryTree root) {
        BinaryTree tmp = null;
        if (root != null){
            makeMirrorOfBinaryTree(root.left);
            makeMirrorOfBinaryTree(root.right);
            tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }
        return tmp;
    }
}
