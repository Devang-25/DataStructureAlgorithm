
package linkedlist;

import static linkedlist.LinkedList.printLinkedList;

/**
 * Created by : Rakesh Gupta on 8/26/17
 * Package : linkedlist
 */

public class DetectCycleInLinkedList {
    public static void main(String[] args) {
        ListNode headN = getPopulatedData(8);

        boolean status = hasCycle(headN);
        System.out.println("LinkedList is : ");
        //printLinkedList(headN);
        System.out.println("LinkedList has cycle : " + status);
        detectCycleAndRemove(headN);
        System.out.println("After deleting node from where cycle start linkedlist is :");
        printLinkedList(headN);
    }

    private static void detectCycleAndRemove(ListNode headN) {
        ListNode slow = headN;
        ListNode fast = headN;

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

    private static void removeNode(ListNode slow, ListNode headNode) {
        ListNode ptr1 = null;
        ListNode ptr2 = null;

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

    private static void removeLoop(ListNode loop, ListNode head) {
        ListNode ptr1 = loop;
        ListNode ptr2 = loop;

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

    private static void detectAndRemoveLoop(ListNode node) {

        // If list is empty or has only one node
        // without loop
        if (node == null || node.next == null)
            return;

        ListNode slow = node, fast = node;

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

    private static boolean hasCycle(ListNode headN) {
        ListNode slow = headN;
        ListNode fast = headN;

        while (slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    public static ListNode getPopulatedData(int head) {
        ListNode headNode = new ListNode(head);
        headNode.next = new ListNode(1);
        headNode.next.next = new ListNode(9);
        headNode.next.next.next = new ListNode(4);
        ListNode s = new ListNode(2);
        headNode.next.next.next.next = s;
        headNode.next.next.next.next.next = new ListNode(3);
        headNode.next.next.next.next.next.next = new ListNode(7);
        headNode.next.next.next.next.next.next.next = new ListNode(2);
        headNode.next.next.next.next.next.next.next.next = new ListNode(9);
        headNode.next.next.next.next.next.next.next.next.next =  s;
        return headNode;
    }

    public ListNode detectCycle(ListNode listNode) {
        ListNode slow = listNode;
        ListNode fast = listNode;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null)
            return null;

        slow = listNode;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
