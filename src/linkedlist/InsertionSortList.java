package linkedlist;

public class InsertionSortList {

    public ListNode insertionSortList(ListNode listNode) {
        ListNode curr = listNode;
        while (curr != null) {
            ListNode temp = curr;
            ListNode swap = null;
            int minVal = Integer.MAX_VALUE;

            while (temp != null) {
                if (temp.data < minVal) {
                    minVal = temp.data;
                    swap = temp;
                }
                temp = temp.next;
            }
            swap.data = curr.data;
            curr.data = minVal;
            curr = curr.next;
        }
        return listNode;
    }
}
