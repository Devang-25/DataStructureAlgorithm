package sample_exercise.linkedlist;

/**
 * Created by rakeshgupta on 2/15/17.
 */
public class Node {
    int data;
    Node point;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getPoint() {
        return point;
    }

    public void setPoint(Node point) {
        this.point = point;
    }
}
