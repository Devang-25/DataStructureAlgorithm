package hackerrank.ds.stack;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by rakeshgupta on 9/25/16.
 */
public class MaximumElement {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        Scanner scanner = new Scanner(System.in);
        int data = 0;
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {

            String s = scanner.nextLine();
                int q = Integer.parseInt(s.split(" ")[0]);
            if (q == 1)
             data = Integer.parseInt(s.split(" ")[1]);

            if (q ==1)
            stack.push(data);
            else if (q ==2)
                stack.pop();
            else 
                printMax(stack);
        }
    }

    private static void printMax(Stack stack) {
        if(!stack.isEmpty()){
            Object max = Collections.max(stack);
            System.out.println(max.toString());
        }
    }
}
