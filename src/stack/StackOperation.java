package stack;

import java.util.Stack;

/**
 * Created by rakeshgupta on 9/23/16.
 */
public class StackOperation {

    public static void main(String args[]){

        Stack<String> stringStack = new Stack<>();
        stringStack.push("A");
        stringStack.push("B");
        stringStack.push("C");

     //   System.out.println(stringStack.size());
     //   System.out.println(stringStack.pop());
        System.out.println(stringStack.size());
        System.out.println(stringStack.empty());
        System.out.println(stringStack.search(new String("B")));

        System.out.println(stringStack.peek());
        System.out.println(stringStack.size());







    }
}
