package linkedlist;

public class MergeTwoSortedLinkedList {
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode start = new ListNode(0);
        ListNode curr = start;

        while (head1 != null && head2 != null) {
            if (head1.data > head2.data) {
                curr.next = new ListNode(head2.data);
                head2 = head2.next;
            } else {
                curr.next = new ListNode(head1.data);
                head1 = head1.next;
            }
            curr = curr.next;
        }

        while (head1 != null) {
            curr.next = new ListNode(head1.data);
            head1 = head1.next;
            curr = curr.next;
        }

        while (head2 != null) {
            curr.next = new ListNode(head2.data);
            head2 = head2.next;
            curr = curr.next;
        }

        return start.next;
    }
}
