package dp;

import java.util.Stack;

public class LongestValidParanthesis {
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        int lastIdx = -1;
        Stack<Integer> leftStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftStack.push(i);
            } else {
                if (leftStack.isEmpty()) {
                    lastIdx = i;
                } else {
                    leftStack.pop();
                    if (leftStack.isEmpty()) {
                        maxLength = Math.max(maxLength, i - lastIdx);
                    } else {
                        maxLength = Math.max(maxLength, i - leftStack.peek());
                    }
                }
            }
        }
        return maxLength;
    }
}
