package stack;

import java.util.Stack;

/**
 * Created by : Rakesh Gupta on 8/19/17
 * Package : stack
 */
public class SortStackElement {
    public static void main(String[] args) {
        Stack s1 = new Stack();
        s1.push(4);
        s1.push(3);
        s1.push(8);
        s1.push(1);
        s1.push(2);

        System.out.println("Without sorted Stack is : " + s1);
        Stack s2 = sortStack(s1);
        System.out.println("After Sorting Stack is : " + s2);
    }

    private static Stack sortStack(Stack s1) {
        Stack tmpStack = new Stack();
        while (!s1.isEmpty()){
            int num = ((Integer) s1.pop());

            while (!tmpStack.isEmpty() && (Integer)tmpStack.peek() > num){
                s1.push(tmpStack.pop());
            }
            tmpStack.push(num);
        }
        return tmpStack;
    }
}
