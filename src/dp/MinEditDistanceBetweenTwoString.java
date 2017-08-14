package dp;

/**
 * Created by : Rakesh Gupta on 8/14/17
 * Package : dp
 */
public class MinEditDistanceBetweenTwoString {
    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "azced";

        int count = minCharacterEdit(s1, s2);
        System.out.println("Minimum character edit in first string to get second string : " + count);

    }

    private static int minCharacterEdit(String s1, String s2) {
        char charArr1[] = s1.toCharArray();
        char charArr2[] = s2.toCharArray();

        int changed[][] = new int[s1.length()+1][s2.length()+1];
        for (int i = 0; i < s1.length(); i++) {
            changed[i][0] = i;
        }

        for (int i = 0; i < changed[0].length; i++) {
            changed[0][i] = i;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j<= s2.length(); j++) {
                if (charArr1[i-1] == charArr2[j-1])
                    changed[i][j] = changed[i-1][j-1];
                else
                    changed[i][j] = 1+MinCostPathInMatrix.getMin(changed[i][j-1], changed[i-1][j], changed[i-1][j-1]);
            }
        }
        return changed[s1.length()][s2.length()];
    }
}
