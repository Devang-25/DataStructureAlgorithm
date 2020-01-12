package stack;

import java.util.Stack;

public class RedundantBraces {
    public static void main(String[] args) {
        System.out.println(findRedundantBraces("((a + b))"));
    }

    public static boolean findRedundantBraces(String exp) {
        Stack<Character> st = new Stack<>();
        char[] str = exp.toCharArray();

        for (char ch : str) {
            if (ch == ')') {
                char top = st.pop();

                // If immediate pop have open parenthesis '('
                // duplicate brackets found
                boolean flag = true;
                while (top != '(') {
                    // Check for operators in expression
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        flag = false;
                    }
                    top = st.pop();
                }
                if (flag == true) {
                    return true;
                }
            } else {
                st.push(ch);
            }
        }
        return false;
    }
}
