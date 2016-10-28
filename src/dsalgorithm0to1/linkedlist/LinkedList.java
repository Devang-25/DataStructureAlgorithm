package dsalgorithm0to1.linkedlist;

/**
 * Created by rakeshgupta on 10/24/16.
 */
public class LinkedList {

    public static void main(String[] args) {
        LinkedListNode linkedListNode = new LinkedListNode(5);
        LinkedListNode linkedListNode1 = new LinkedListNode(10);
        linkedListNode.setNext(linkedListNode1);
        linkedListNode1.setNext(new LinkedListNode(15));

        printLinkedList(linkedListNode);
        int length = getLengthOfLL(linkedListNode);
        System.out.println(length);
        insertElementAtEnd(linkedListNode, new LinkedListNode(20));
        printLinkedList(linkedListNode);
        System.out.println(getLengthOfLL(linkedListNode));
    }

    private static void insertElementAtEnd(LinkedListNode linkedListNode, LinkedListNode add) {
        while (linkedListNode.getNext() != null){
            linkedListNode = linkedListNode.getNext();
        }
        linkedListNode.setNext(add);
    }

    private static int getLengthOfLL(LinkedListNode linkedListNode) {
        int length = 0;
        while (linkedListNode != null){
            length++;
            linkedListNode = linkedListNode.getNext();
        }
        return length;
    }

    private static void printLinkedList(LinkedListNode linkedListNode) {
        while (linkedListNode != null){
            System.out.print(linkedListNode.getData()+"->");
            linkedListNode = linkedListNode.getNext();
        }
        System.out.println("null");
    }

    public static class LinkedListNode{
        int data;
        LinkedListNode next;

        public LinkedListNode(int data) {
            this.data = data;
        }

        public LinkedListNode getNext() {
            return next;
        }

        public void setNext(LinkedListNode next) {
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }
}
