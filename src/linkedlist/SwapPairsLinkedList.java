package linkedlist;

public class SwapPairsLinkedList {
    public ListNode swapPairs(ListNode listNode) {
        if (listNode == null || listNode.next == null) return listNode;
        ListNode head = listNode.next;
        ListNode prev = null;

        while (listNode != null && listNode.next != null) {
            ListNode temp = listNode.next;
            listNode.next = listNode.next.next;
            temp.next = listNode;
            if (prev != null) prev.next = temp;
            prev = listNode;
            listNode = listNode.next;
        }
        return head;
    }
}
