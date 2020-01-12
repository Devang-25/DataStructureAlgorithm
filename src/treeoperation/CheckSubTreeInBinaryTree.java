package treeoperation;

import tree.BinaryTree;
import tree.BinaryTreeData;

/**
 * Created by : Rakesh Gupta on 8/21/17
 * Package : treeoperation
 */
public class CheckSubTreeInBinaryTree {
    public static void main(String[] args) {
        BinaryTree root1 = BinaryTreeData.getBSTData(2, 10);
        BinaryTree root2 = BinaryTreeData.getBSTData(18, 10);
        BinaryTree.printTree(root1);
        boolean check = checkSubTree(root1, root1);
        System.out.println("Checking if tree2 is subtree of large tree1 : " + check);
    }


    private static boolean checkSubTree(BinaryTree root1, BinaryTree root2) {
        if (root2 == null)
            return true;
        else
            return subTree(root1, root2);
    }

  private static boolean subTree(BinaryTree r1, BinaryTree r2) {
        if (r1 == null)
            return false;

        if (r1.getData() == r2.getData()) {
            if (matchTree(r1,r2))
                return true;
        }
        return (subTree(r1.left, r2) || subTree(r1.right, r2));
    }

    private static boolean matchTree(BinaryTree r1, BinaryTree r2) {
        if (r2 == null && r1 == null)
            return true;

        if (r1 == null || r2 == null)
            return false;

        if (r1.getData() != r2.getData())
            return false;
        return (matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right));
    }
}
