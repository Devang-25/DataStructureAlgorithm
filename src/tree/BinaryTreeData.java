package tree;

/**
 * Created by rakeshgupta on 4/2/17.
 */
public class BinaryTreeData {
    public static BinaryTree GetPopulatedData(){
        BinaryTree binaryTree = new BinaryTree(1);
        BinaryTree left1 = new BinaryTree(2);
        BinaryTree right1 = new BinaryTree(3);
        left1.setLeft(new BinaryTree(4));
        left1.setRight(new BinaryTree(5));

        right1.setLeft(new BinaryTree(6));
        right1.setRight(new BinaryTree(7));

        binaryTree.setLeft(left1);
        binaryTree.setRight(right1);
        return binaryTree;
    }
}
