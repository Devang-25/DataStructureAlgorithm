package linkedlist;


//Write code to partition a linked list around a value x, such that
//all nodes less than x come before all nodes greater than or equal to x.

public class Partition {
    ListNode partition(ListNode node, int x) {
        ListNode head = node;
        ListNode tail = node;

        while (node != null) {
            ListNode next = node.next;
            if (node.data < x) {
                /* insert node at head */
                node.next = head;
                head = node;
            } else {
                /* insert node at tail */
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;

        //the head has changed, so we need to return it to the user
        return head;
    }
}
