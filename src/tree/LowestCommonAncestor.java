package tree;

/**
 * Created by rakeshgupta on 7/9/17.
 */
public class LowestCommonAncestor {

    private static boolean v1, v2;

    public static void main(String[] args) {

        //BinaryTree binaryTree = BinaryTreeData.GetPopulatedData();
        BinaryTree binaryTree = new BinaryTree(1);
        BinaryTree left1 = new BinaryTree(2);
        BinaryTree right1 = new BinaryTree(5);

        binaryTree.setLeft(left1);
        binaryTree.setRight(new BinaryTree(3));

        left1.setLeft(new BinaryTree(4));
        left1.setRight(right1);

        right1.setLeft(new BinaryTree(7));
        right1.setRight(new BinaryTree(8));

        BinaryTree.printTree(binaryTree);

//        BinaryTree ancestorNode = getLowestCommonAncestor(binaryTree, 4, 71);
//        if (ancestorNode != null)
//            System.out.println(ancestorNode.getData());
//        else
//            System.out.println("No ancestor node");

        System.out.println("------------------------------------------------------------------------------------");
        BinaryTree ancestorNode2 = getLCAEfficient(binaryTree, 4, 71);
        if ((ancestorNode2 != null) && v1 && v2)
            System.out.println(ancestorNode2.getData());
        else
            System.out.println("No ancestor node");
    }

    public static BinaryTree getLowestCommonAncestor(BinaryTree currNode, int a, int b) {
        if (currNode == null) {
            return null;
        }
        if (currNode.getData() == a || currNode.getData() == b) {
            return currNode;
        }
        BinaryTree left = getLowestCommonAncestor(currNode.getLeft(), a, b);
        BinaryTree right = getLowestCommonAncestor(currNode.getRight(), a, b);

        if (left != null && right != null) {
            return currNode;
        }
        if (left != null)
            return left;
        else
            return right;
    }

    public static BinaryTree getLCAEfficient(BinaryTree root, int a, int b){
        if (root == null) return null;
        BinaryTree temp = null;
        if (root.getData() == a){
            v1 = true;
            temp = root;
        }
        if (root.getData() == b){
            v2 = true;
            temp = root;
        }
        BinaryTree leftLCA = getLCAEfficient(root.getLeft(), a, b);
        BinaryTree rightLCA = getLCAEfficient(root.getRight(), a, b);

        if (temp != null)
            return temp;

        if (leftLCA != null && rightLCA != null){
            return root;
        }
        return leftLCA != null ? leftLCA : rightLCA;
    }
}
