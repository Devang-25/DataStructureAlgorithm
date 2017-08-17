package pattern;

/**
 * Created by : Rakesh Gupta on 8/18/17
 * Package : pattern
 */
public class SearchPattern {
    public static void main(String[] args) {
        String text = "AABCBDSJFLKDSAABC";
        String pattern = "AABC";

        searchPattern(text, pattern);
    }

    private static void searchPattern(String text, String pattern) {
        int textLen = text.length();
        int patternLen = pattern.length();

        for (int i = 0; i <= textLen - patternLen; i++) {
            int j = 0;
            for (j = 0; j < patternLen; j++) {
                if (text.charAt(i+j) != pattern.charAt(j))
                    break;
            }
            if (j == patternLen)
                System.out.println("Pattern found at index : " + i);
        }
    }
}
