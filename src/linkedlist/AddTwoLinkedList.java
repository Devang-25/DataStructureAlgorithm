package linkedlist;

public class AddTwoLinkedList {
    public static void main(String[] args) {
        ListNode head1 = ListNode.getPopulatedListNode();
        ListNode head2 = ListNode.getPopulatedListNode2();
        ListNode.printListNode(head1);
        ListNode.printListNode(head2);
        ListNode newHead = addTwoLinkedListNode(head1, head2);
        ListNode.printListNode(newHead);
    }

    public static ListNode addTwoLinkedListNode(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) return null;

        if (head1 == null) return head2;
        if (head2 == null) return head1;
        ListNode ans = new ListNode(0);
        ListNode newHead = ans;
        int carry = 0;
        int data = 0;
        while (head1 != null || head2 != null) {
            data = carry + head1.data + head2.data;
            carry = data / 10;

            ans.next = new ListNode(data % 10);
            ans = ans.next;

            head1 = head1.next;
            head2 = head2.next;
        }
        while (head1 != null) {
            data = carry + head1.data;
            carry = data % 10;
            ans.next = new ListNode(data / 10);
            ans = ans.next;
            head1 = head1.next;
        }
        while (head2 != null) {
            data = carry + head2.data;
            carry = data % 10;
            ans.next = new ListNode(data / 10);
            ans = ans.next;
            head2 = head2.next;
        }
        if (carry != 0) {
            ans.next = new ListNode(carry);
            ans = ans.next;
        }
        return newHead.next;
    }
}
