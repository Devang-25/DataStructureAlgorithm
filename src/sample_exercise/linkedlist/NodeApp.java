package sample_exercise.linkedlist;

/**
 * Created by rakeshgupta on 2/15/17.
 */
public class NodeApp {
    public static void main(String[] args) {
        Node root = new Node(4);
        Node next = new Node(5);
        next.setData(6);
        root.point = next;
        System.out.println(root.getData());
        System.out.println(root.point.getData());

    }
}
