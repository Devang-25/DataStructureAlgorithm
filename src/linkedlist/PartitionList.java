package linkedlist;

public class PartitionList {
    public ListNode partition(ListNode listNode, int num) {
        ListNode list1 = new ListNode(0);
        ListNode list2 = new ListNode(0);

        ListNode curr1 = list1;
        ListNode curr2 = list2;

        while (listNode != null) {
            if (listNode.data < num) {
                curr1.next = new ListNode(listNode.data);
                curr1 = curr1.next;
            } else {
                curr2.next = new ListNode(listNode.data);
                curr2 = curr2.next;
            }
            listNode = listNode.next;
        }
        curr1.next = list2.next;
        return list1.next;
    }
}
