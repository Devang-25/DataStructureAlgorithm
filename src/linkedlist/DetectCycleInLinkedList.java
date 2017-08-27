
package linkedlist;

import static linkedlist.LinkedList.printLinkedList;


/**
 * Created by : Rakesh Gupta on 8/26/17
 * Package : linkedlist
 */

public class DetectCycleInLinkedList {
    public static void main(String[] args) {
    LinkedList.LinkedListNode headN = getPopulatedData(8);

        boolean status = hasCycle(headN);
        System.out.println("LinkedList is : ");
        //printLinkedList(headN);
        System.out.println("LinkedList has cycle : " + status);
        detectCycleAndRemove(headN);
        System.out.println("After deleting node from where cycle start linkedlist is :");
        printLinkedList(headN);
    }

    private static void detectCycleAndRemove(LinkedList.LinkedListNode headN) {
        LinkedList.LinkedListNode slow = headN;
        LinkedList.LinkedListNode fast = headN;

        while (slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                removeLoop(slow, headN);
                return;
            }
        }
        return;
    }

    private static void removeNode(LinkedList.LinkedListNode slow, LinkedList.LinkedListNode headNode) {
        LinkedList.LinkedListNode ptr1 = null;
        LinkedList.LinkedListNode ptr2 = null;

        ptr1 = headNode;
        while (true){
            ptr2 = slow;
            while (ptr2.next != slow && ptr2.next != ptr1)
                ptr2 = ptr2.next;

            if (ptr2.next == ptr1)
                break;

            ptr1 = ptr1.next;
        }
        ptr2.next = null;
    }

    private static void removeLoop(LinkedList.LinkedListNode loop, LinkedList.LinkedListNode head) {
        LinkedList.LinkedListNode ptr1 = loop;
        LinkedList.LinkedListNode ptr2 = loop;

        int k = 1, i;
        while (ptr1.next != ptr2) {
            ptr1 = ptr1.next;
            k++;
        }

        ptr1 = head;
        ptr2 = head;

        for (i = 0; i < k; i++) {
            ptr2 = ptr2.next;
        }

        while (ptr2 != ptr1) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        ptr2 = ptr2.next;
        while (ptr2.next != ptr1) {
            ptr2 = ptr2.next;
        }
        ptr2.next = null;
    }

    private static void detectAndRemoveLoop(LinkedList.LinkedListNode node) {

        // If list is empty or has only one node
        // without loop
        if (node == null || node.next == null)
            return;

        LinkedList.LinkedListNode slow = node, fast = node;

        // Move slow and fast 1 and 2 steps
        // ahead respectively.
        slow = slow.next;
        fast = fast.next.next;

        // Search for loop using slow and fast pointers
        while (fast != null && fast.next != null) {
            if (slow == fast)
                break;

            slow = slow.next;
            fast = fast.next.next;
        }

        /* If loop exists */
        if (slow == fast) {
            slow = node;
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }

            /* since fast->next is the looping point */
            fast.next = null; /* remove loop */
        }
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
