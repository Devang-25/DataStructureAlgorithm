package string;


//Write code to remove duplicates from an unsorted linked list

import linkedlist.ListNode;

import java.util.HashSet;

public class DeleteDups {

    void deleteDups(ListNode n) {
        HashSet<Integer> set = new HashSet<Integer>();
        ListNode previous = null;
        while (n != null) {
            if (set.contains(n.getData())) {
                ListNode temp = previous.getNext();
                temp = n.getNext();
            } else {
                set.add(n.getData());
                previous = n;
            }
            n = n.getNext();
        }
    }
}
