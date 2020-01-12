package linkedlist;

import java.util.Arrays;

public class SortList {
    public ListNode sortList(ListNode listNode) {
        int[] arr = new int[getLength(listNode)];
        ListNode curr = listNode;
        int i = 0;
        while (curr != null) {
            arr[i++] = curr.data;
            curr = curr.next;
        }
        Arrays.sort(arr);
        curr = listNode;
        i = 0;
        while (curr != null) {
            curr.data = arr[i++];
            curr = curr.next;
        }
        return listNode;
    }

    public int getLength(ListNode listNode) {
        int len = 0;
        while (listNode != null) {
            listNode = listNode.next;
            len++;
        }
        return len;
    }
}
