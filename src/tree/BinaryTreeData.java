package tree;

import java.util.Random;

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

    public static  BinaryTree getRandomPopulatedData(){
        BinaryTree root = new BinaryTree(4);
        root.left = new BinaryTree(66);
        root.right = new BinaryTree(23);

        root.left.left = new BinaryTree(44);
        root.right.right = new BinaryTree(2);

        root.right.left  = new BinaryTree(9);
        root.right.left.left = new BinaryTree(8);
        root.right.left.right = new BinaryTree(78);

        root.right.right.right = new BinaryTree(98);
        root.right.right.right.left = new BinaryTree(76);

        return root;
    }

    public static BinaryTree getBSTData(int rootData, int numOfData){
        BinaryTree root = new BinaryTree(rootData);

        for (int i = 1; i < numOfData; i++) {
            BinaryTree.add(root, new Random(i).nextInt(i));
        }
        return root;
    }

    public static void main(String[] args) {
        BinaryTree.preOrder(getBSTData(3, 100));
    }
}
