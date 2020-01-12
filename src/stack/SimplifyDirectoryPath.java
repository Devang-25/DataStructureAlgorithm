package stack;

import java.util.Stack;

public class SimplifyDirectoryPath {
    public static void main(String[] args) {
        System.out.println(getAbsolutePath("/a/./b/../../c/"));
    }

    public static String getAbsolutePath(String pathStr) {
        Stack<String> stack = new Stack<>();
        String[] arr = pathStr.trim().split("/");
        for (String s : arr) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!s.isEmpty() && !s.equals(".")) {
                stack.push(s);
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop());
            ans.insert(0, "/");
        }

        return ans.length() != 0 ? ans.toString() : "/";
    }
}
