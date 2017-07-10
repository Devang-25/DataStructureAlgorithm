package tree;

/**
 * Created by rakeshgupta on 7/9/17.
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {

        //BinaryTree binaryTree = BinaryTreeData.GetPopulatedData();
        BinaryTree binaryTree = new BinaryTree(1);
        BinaryTree left1 = new BinaryTree(2);
        BinaryTree right1 = new BinaryTree(5);

        binaryTree.setLeft(left1);
        binaryTree.setRight(new BinaryTree(3));

        left1.setLeft(new BinaryTree(4));
        left1.setRight(right1);;

        right1.setLeft(new BinaryTree(7));
        right1.setRight(new BinaryTree(8));

        BinaryTree a = new BinaryTree(4);
        BinaryTree b = new BinaryTree(2);

        BinaryTree.postOrder(binaryTree);

        BinaryTree ancestorNode = getLowestCommonAncestor(binaryTree, a, b);
        if (ancestorNode != null)
            System.out.println(ancestorNode.getData());
        else
            System.out.println("No ancestor node");
    }

    public static BinaryTree getLowestCommonAncestor(BinaryTree currNode, BinaryTree a, BinaryTree b) {

        if (currNode == null) {
            return null;
        }

        if (currNode == a || currNode == b) {
            return currNode;
        }

        BinaryTree left = getLowestCommonAncestor(currNode.getLeft(), a, b);
        BinaryTree right = getLowestCommonAncestor(currNode.getRight(), a, b);

        if (left != null && right != null) {
            return currNode;
        }

        if (left == null)
            return right;
        else
            return left;
    }

}
