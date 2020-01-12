package linkedlist;

public class ReverseGivenRangeLinkedList {
    public ListNode reverseBetween(ListNode listNode, int m, int n) {
        if (listNode == null || m == n) {
            return listNode;
        }

        ListNode ans = new ListNode(0);
        ans.next = listNode;
        int pos = 1;
        ListNode start = ans;
        ListNode curr = listNode;
        while (pos < m) {
            start = curr;
            curr = curr.next;
            pos++;
        }

        ListNode prev = null;
        ListNode tail = curr;
        while (pos <= n) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            pos++;
        }
        start.next = prev;
        tail.next = curr;
        return ans.next;
    }
}
