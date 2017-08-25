package string;

/**
 * Created by : Rakesh Gupta on 8/12/17
 * Package : string
 */
public class AnagramPatternSearch {
    public static void main(String[] args) {
        String text = "ideserveaveer";
        String pattern = "veer";
        isPatternMatch(text, pattern);
    }

    private static void isPatternMatch(String text, String pattern) {
        char textArr[] = text.toCharArray();
        char patternArr[] = pattern.toCharArray();

        char countText[] = new char[256];
        char countPattern[] = new char[256];

        for (int i = 0; i < pattern.length(); i++) {
            countPattern[patternArr[i]]++;
            countText[textArr[i]]++;
        }

        for (int i = pattern.length(); i < text.length(); i++) {
            if (compare(countPattern, countText))
                System.out.println("Found at Index : " + (i-pattern.length()));

            countText[textArr[i]]++;
            countText[textArr[i-pattern.length()]]--;
        }

        if (compare(countPattern, countText))
            System.out.println("Found at Index : " + (text.length()-pattern.length()));
    }

    private static boolean compare(char[] countPattern, char[] countText) {
        for (int i = 0; i < 256; i++) {
            if (countPattern[i] != countText[i])
                return false;
        }
        return true;
    }
}
