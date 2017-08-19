package tree;

/**
 * Created by rakeshgupta on 7/9/17.
 */
public class BinaryTree {
    public BinaryTree left;
    public BinaryTree right;
    int data;

    public BinaryTree(int data) {
        this.data = data;
    }

    public BinaryTree getLeft() {

        return left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public static void postOrder(BinaryTree root){
        if (root == null)
            return;
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getData() + " ");
    }

    public static void preOrder(BinaryTree root){
        if (root == null)
            return;
        System.out.print(root.getData()+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(BinaryTree root){
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.getData()+" ");
        inOrder(root.right);
    }

    public static void add(BinaryTree root, int data){
        BinaryTree node = new BinaryTree(data);
        if (root == null)
            root = node;
        else
            traverseAndAddBinaryNode(root, node);
    }

    public static void traverseAndAddBinaryNode(BinaryTree root, BinaryTree node) {
        if (node.getData() < root.data) {
            if (root.getLeft() == null)
                root.left = node;
            else
                traverseAndAddBinaryNode(root.left, node);
        } else if (node.data > root.data) {
            if (root.right == null)
                root.right = node;
            else
                traverseAndAddBinaryNode(root.right, node);
        }
    }
}
