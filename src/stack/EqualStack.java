package stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by rakeshgupta on 9/25/16.
 */
public class EqualStack {
    static int ans =0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s1 = scanner.nextInt();
        int s2 = scanner.nextInt();
        int s3 = scanner.nextInt();

        Stack<Integer> stack1 = new Stack<>();
        for (int i = 0; i < s1; i++) {
            stack1.push(scanner.nextInt());
        }

        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < s2; i++) {
            stack2.push(scanner.nextInt());
        }

        Stack<Integer> stack3 = new Stack<>();
        for (int i = 0; i < s3; i++) {
            stack3.push(scanner.nextInt());
        }

        while (!check(stack1, stack2, stack3)){
            int max = Math.max(sum(stack1), Math.max(sum(stack2), sum(stack3)));
            if (max == sum(stack1))
                stack1.pop();
            else if (max == sum(stack2))
                stack2.pop();
            else
                stack3.pop();
        }
        System.out.println(ans);
    }

    private static boolean check(Stack<Integer> stack1, Stack<Integer> stack2, Stack<Integer> stack3) {

        if((sum(stack1)==sum(stack2)) && (sum(stack1)==sum(stack3))) {
            ans = sum(stack1);
            return true;
        }
        else
            return false;
    }

    private static int sum(Stack<Integer> stack) {
        int sum = 0;
        for(int i=0;i<stack.size();i++){
            sum = sum + stack.pop();
        }
        return sum;

    }
}
