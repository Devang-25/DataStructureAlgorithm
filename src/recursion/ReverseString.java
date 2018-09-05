package recursion;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        System.out.println("Reverse of: " + input + " is :" + reverseString(input));
    }

    private static String reverseString(String input) {
        String subSolution = "";
        String subProblem = "";
        if ("".equals(input)) {
            return input;
        } else {
            subProblem = input.substring(1);
            subSolution = reverseString(subProblem);
            return subSolution + input.substring(0, 1);
        }
    }
}
