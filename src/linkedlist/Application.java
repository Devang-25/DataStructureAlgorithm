package linkedlist;

import java.util.LinkedList;

/**
 * Created by rakeshgupta on 9/23/16.
 */
public class Application {

    public static void main(String args[]){

        LinkedList linkedList = new LinkedList();
        linkedList.add(339);
        linkedList.add(new String("ABCD"));
        linkedList.add(333.45);
        linkedList.add("Allahabad");

        System.out.println(linkedList);
    }
}
