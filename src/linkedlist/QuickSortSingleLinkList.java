package linkedlist;

public class QuickSortSingleLinkList {

    public static void main(String[] args) {

        QuickSortSingleLinkList algorithm = new QuickSortSingleLinkList();

        ListNode head = new ListNode(4);
        head.next = new ListNode(1);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(3);


        System.out.println("Before Sorting");
        algorithm.print(head);
        algorithm.quickSort(head);
        System.out.println("\nAfter Sorting");
        algorithm.print(head);
    }

    public void print(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    public ListNode quickSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return quick(head, null);
    }

    private ListNode quick(ListNode start, ListNode end) {
        if (start == null || start == end || start.next == end) {
            return start;
        }

        ListNode[] result = partition(start, end);
        ListNode resultLeft = quick(result[0], result[1]);
        ListNode resultRight = quick(result[1].next, end);
        return resultLeft;
    }

    private ListNode[] partition(ListNode start, ListNode end) {
        // start inclusive
        // end exclusive
        // return the new start node and the pivot node

        if (start == null || start == end || start.next == end) {
            return new ListNode[]{start, start};
        }
        ListNode dummy = new ListNode(0);
        dummy.next = start;

        for (ListNode j = start; j != null && j.next != null && j.next != end; j = j.next) {
            while (j.next != null && j.next.value <= start.value) {
                ListNode tmp = j.next;
                j.next = j.next.next;
                tmp.next = dummy.next;
                dummy.next = tmp;
            }
        }

        return new ListNode[]{dummy.next, start};
    }

    static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }
}
