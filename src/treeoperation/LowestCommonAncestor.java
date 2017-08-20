package treeoperation;

import tree.BinaryTree;
import tree.BinaryTreeData;

/**
 * Created by : Rakesh Gupta on 8/21/17
 * Package : treeoperation
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        BinaryTree root = BinaryTreeData.getRandomPopulatedData();
        BinaryTree one = new BinaryTree(2);
        BinaryTree two = new BinaryTree(9);

        BinaryTree ancestorNode = getLowestCommonAncestorNode(root, one, two);
        if (ancestorNode != null)
            System.out.println("Lowest common ancestor node is : " + ancestorNode.getData());
        else
            System.out.println("No Lowest common ancestor node found ");
    }

    private static BinaryTree getLowestCommonAncestorNode(BinaryTree root, BinaryTree p, BinaryTree q) {

        if (covers(root.left, p) && covers(root.left, q))
            return getLowestCommonAncestorNode(root.left, p, q);

        if (covers(root.right, p) && covers(root.right, q))
            return getLowestCommonAncestorNode(root.right, p, q);

        return root;
    }

    private static boolean covers(BinaryTree root, BinaryTree p) {

        if (root == null)
            return false;

        if (root == p)
            return true;

        return covers(root.left, p) || covers(root.right, p);
    }

}
