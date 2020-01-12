package string;

public class MinCharToMakeStringPalindromic {
    public static void main(String[] args) {
        System.out.println(minCharCount("ABC"));
    }

    public static int minCharCount(String str) {
        String reverseCopy = new StringBuffer(str).reverse().toString();
        int start = 0, end = 0, count = 0;
        while (true) {
            if (isPalindrome(reverseCopy.substring(start, end) + str)) break;
            end++;
            count++;
        }
        return count;
    }

    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString().equals(s);
    }
}
