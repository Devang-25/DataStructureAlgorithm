package stack;

import java.util.Stack;

public class SpecialStackWithConstantTimeMinCheck {

    private static Stack<Integer> stack;
    private static Integer minElement;

    public SpecialStackWithConstantTimeMinCheck() {
        stack = new Stack<>();
    }

    public static void main(String[] args) {
        SpecialStackWithConstantTimeMinCheck s = new SpecialStackWithConstantTimeMinCheck();
        s.push(3);
        s.push(5);
        System.out.println(s.getMin());
        s.push(2);
        s.push(1);
        System.out.println(s.getMin());
        System.out.println(s.peek());
        System.out.println(s.getMin());
        System.out.println(s.pop());
        System.out.println(s.peek());
    }

    private static Integer getMin() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
        }
        return minElement;
    }

    private static Integer pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
        }
        Integer num = stack.pop();
        Integer minTemp = minElement;
        if (num < minElement) {
            minElement = 2 * minElement - num;
            return minTemp;
        } else {
            return num;
        }
    }

    private static void push(Integer n) {
        if (stack.isEmpty()) {
            minElement = n;
            stack.push(n);
            return;
        }
        if (n < minElement) {
            stack.push(2 * n - minElement);
            minElement = n;
        } else {
            stack.push(n);
        }
    }

    private static Integer peek() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
        }
        Integer num = stack.peek();
        if (num < minElement) return minElement;
        else return num;
    }
}
