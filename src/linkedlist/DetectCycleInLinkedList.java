package linkedlist;

/**
 * Created by : Rakesh Gupta on 8/26/17
 * Package : linkedlist
 */
public class DetectCycleInLinkedList {
    public static void main(String[] args) {
    LinkedList.LinkedListNode headN = getPopulatedData(8);

    boolean status = hasCycle(headN);
        System.out.println("LinkedList has cycle : " + status);

    }

    private static boolean hasCycle(LinkedList.LinkedListNode headN) {
        LinkedList.LinkedListNode slow = headN;
        LinkedList.LinkedListNode fast = headN;

        while (slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    public static LinkedList.LinkedListNode getPopulatedData(int head){
        LinkedList.LinkedListNode headNode = new LinkedList.LinkedListNode(head);
        headNode.next = new LinkedList.LinkedListNode(1);
        headNode.next.next = new LinkedList.LinkedListNode(9);
        headNode.next.next.next = new LinkedList.LinkedListNode(4);
        LinkedList.LinkedListNode s = new LinkedList.LinkedListNode(2);
        headNode.next.next.next.next = s;
        headNode.next.next.next.next.next = new LinkedList.LinkedListNode(3);
        headNode.next.next.next.next.next.next = new LinkedList.LinkedListNode(7);
        headNode.next.next.next.next.next.next.next = new LinkedList.LinkedListNode(2);
        headNode.next.next.next.next.next.next.next.next = new LinkedList.LinkedListNode(9);
        headNode.next.next.next.next.next.next.next.next.next =  s;
        return headNode;
    }
}
