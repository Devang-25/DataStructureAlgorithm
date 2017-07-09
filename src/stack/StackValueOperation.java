package stack;

import java.util.Collections;
import java.util.Stack;

/**
 * Created by rakeshgupta on 9/25/16.
 */

public class StackValueOperation {
    public static void main(String[] args){
        Stack lifo = new Stack();
        lifo.push(new Integer(4));
        lifo.push(new Integer(1));
        lifo.push(new Integer(150));
        lifo.push(new Integer(40));
        lifo.push(new Integer(0));
        lifo.push(new Integer(60));
        lifo.push(new Integer(47));
        lifo.push(new Integer(104));

        if(!lifo.isEmpty()){
            Object max = Collections.max(lifo);
            System.out.println("max=" + max.toString());
        }
    }
}


