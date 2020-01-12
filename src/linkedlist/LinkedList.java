package linkedlist;

/**
 * Created by rakeshgupta on 10/24/16.
 */
public class LinkedList {

    public static void main(String[] args) {
        ListNode linkedListNode = new ListNode(5);
        ListNode linkedListNode1 = new ListNode(10);
        linkedListNode.setNext(linkedListNode1);
        linkedListNode1.setNext(new ListNode(15));

        printLinkedList(linkedListNode);
        int length = getLengthOfLL(linkedListNode);
        System.out.println(length);
        insertElementAtEnd(linkedListNode, new ListNode(20));
        printLinkedList(linkedListNode);
        System.out.println(getLengthOfLL(linkedListNode));
    }

    private static void insertElementAtEnd(ListNode linkedListNode, ListNode add) {
        while (linkedListNode.getNext() != null){
            linkedListNode = linkedListNode.getNext();
        }
        linkedListNode.setNext(add);
    }

    private static int getLengthOfLL(ListNode linkedListNode) {
        int length = 0;
        while (linkedListNode != null){
            length++;
            linkedListNode = linkedListNode.getNext();
        }
        return length;
    }

    public static void printLinkedList(ListNode linkedListNode) {
        while (linkedListNode != null){
            System.out.print(linkedListNode.getData() + "̥->");
            linkedListNode = linkedListNode.getNext();
        }
        System.out.println("null");
    }
}
