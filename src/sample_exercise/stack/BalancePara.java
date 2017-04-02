package sample_exercise.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by rakeshgupta on 9/23/16.
 */
public class BalancePara {


    public static void main(String aargs[]) {

        Stack stackPara = new Stack();
        Stack stackCur = new Stack();

        System.out.println("Enter your String");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char one = arr[i];

            try {

                if (one == '(') {
                    stackPara.push(one);
                } else if (one == '{') {
                    stackCur.push(one);
                } else if (one == ')') {
                    stackPara.pop();
                } else if (one == '}') {
                    stackCur.pop();
                }
            } catch (Exception e) {
                System.out.println(" Not a Balance Paranthesis ");
                System.exit(0);
            }
        }
        System.out.print("Balance Paranthesis ");
    }
}
