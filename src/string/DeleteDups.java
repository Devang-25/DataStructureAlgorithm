package string;


//Write code to remove duplicates from an unsorted linked list

import linkedlist.LinkedList;

import java.util.HashSet;

public class DeleteDups {

    void deleteDups(LinkedList.LinkedListNode n) {
        HashSet<Integer> set = new HashSet<Integer>();
        LinkedList.LinkedListNode previous = null;
        while (n != null) {
            if (set.contains(n.getData())) {
                LinkedList.LinkedListNode temp = previous.getNext();
                temp = n.getNext();
            } else {
                set.add(n.getData());
                previous = n;
            }
            n = n.getNext();
        }
    }
}
