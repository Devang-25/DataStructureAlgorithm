package tree.binarytree;
import queue.QueueImpl;

/**
 * Created by rakeshgupta on 10/18/16.
 */
public class BinaryTree {

    public static void main(String[] args)
            throws QueueImpl.QueueUnderflowException,
            QueueImpl.QueueOverflowException {

        Node first = new Node(10);
        Node leftChild = new Node(9);
        Node rightChild = new Node(11);

        first.setLeftChild(leftChild);
        first.setRightChild(rightChild);

        Node leftChild4 = new Node(4);
        Node rightChild15 = new Node(15);

        leftChild.setLeftChild(leftChild4);
        rightChild.setRightChild(rightChild15);

        leftChild4.setLeftChild(new Node(3));
        leftChild4.setRightChild(new Node(6));

        rightChild15.setLeftChild(new Node(14));
        rightChild15.setRightChild(new Node(18));

        System.out.print(" Breadth First Search : [ ");
        breadthFirst(first);
        System.out.print("]");

        System.out.println();

        System.out.print(" Depth First Search(PREORDER) : [ ");
        preOrder(first);
        System.out.print("]");

        System.out.println();

        System.out.print(" Depth First Search(INORDER) : [ ");
        inOrder(first);
        System.out.print("]");

        System.out.println();

        System.out.print(" Depth First Search(POSTORDER) : [ ");
        postOrder(first);
        System.out.print("]");


    }

//  Depth First Search Algorithm(First way to traverse- PREORDER)
    public static void preOrder(Node root){

        if (root == null)
            return;

        printNode(root);
        preOrder(root.getLeftChild());
        preOrder(root.getRightChild());

    }

    //  Depth First Search Algorithm(Second way to traverse- INORDER)
    public static void inOrder(Node root){

        if (root == null)
            return;

        inOrder(root.getLeftChild());
        printNode(root);
        inOrder(root.getRightChild());
    }

    //  Depth First Search Algorithm(Third way to traverse- POSTORDER)
    public static void postOrder(Node root){

        if (root == null)
            return;

        postOrder(root.getLeftChild());
        postOrder(root.getRightChild());
        printNode(root);
    }


    public static void breadthFirst(Node root)
            throws QueueImpl.QueueOverflowException,
            QueueImpl.QueueUnderflowException{
        if (root == null)
            return;

        QueueImpl<Node> queue = new QueueImpl<>(Node.class);
        queue.enqueue(root);

        while (!queue.isEmpty()){


            Node node = queue.dequeue();
            printNode(node);

            if (node.getLeftChild() != null)
                queue.enqueue(node.getLeftChild());

            if (node.getRightChild() != null)
                queue.enqueue(node.getRightChild());
        }
    }

    private static void printNode(Node node) {
        System.out.print(node.getData() + " ");
    }

    public static class Node<T> {

        private T data;
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public Node<T> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node<T> leftChild) {
            this.leftChild = leftChild;
        }

        public Node<T> getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node<T> rightChild) {
            this.rightChild = rightChild;
        }
    }
}
