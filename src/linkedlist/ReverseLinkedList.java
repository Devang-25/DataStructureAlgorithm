package linkedlist;

import javax.naming.ldap.PagedResultsControl;

public class ReverseLinkedList {
    public static void main(String[] args) {

        Node head = getPopulatedLL();
        printLinkedList(head);
        Node reversedLinkedList = reverse(head);
        printLinkedList(reversedLinkedList);
    }

    private static Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.point;
            current.point = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }


    private static Node getPopulatedLL(){
        Node head = new Node(10);
        Node first = new Node(11);
        Node second = new Node(12);
        Node third = new Node(13);
        Node four = new Node(14);

        head.point = first;
        first.point = second;
        second.point = third;
        third.point = four;
        four.point = null;
        return head;
    }

    public static void printLinkedList(Node head) {
        while (head != null){
            System.out.print(head.getData()+"-> ");
            head = head.getPoint();
        }
        System.out.println("null");
    }
}
