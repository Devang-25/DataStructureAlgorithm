package recursion;

public class LongestPalindromicSubString {
    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubString().longestPalindrome("abdkba"));
    }

    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;

        for (int i=0;i<s.length();i++) {
            int len1 = expandMid(s, i, i);
            int len2 = expandMid(s, i, i+1);

            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }

        return s.substring(start, end + 1);
    }

    public int expandMid(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
