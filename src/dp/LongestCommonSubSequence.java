package dp;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rakeshgupta on 7/9/17.
 */
public class LongestCommonSubSequence {

    private static Set<Character> commonSubSequence = new HashSet<>();

    public static void main(String[] args) {

        String str1 = "abrpge";
        String str2 = "abcde";
        char charArr1[] = str1.toCharArray();
        char charArr2[] = str2.toCharArray();

        System.out.println("Length of LCS is : " + getLCS(charArr1, charArr2, str1.length(), str2.length()));

        System.out.println("Length of LCS using Memoization(BottomUp) is  : " + getLongestCommonSubSeq(charArr1, charArr2));

        System.out.println(commonSubSequence);
    }

    private static int getLongestCommonSubSeq(char[] charArr1, char[] charArr2) {
        int aLen = charArr1.length;
        int bLen = charArr2.length;

        int table[][] = new int[aLen + 1][bLen + 1];

        for (int i = 0; i <= aLen; i++) {
            for (int j = 0; j <= bLen; j++) {
                if (i == 0 || j == 0) table[i][j] = 0;
                else if (charArr1[i - 1] == charArr2[j - 1]) {
                    table[i][j] = 1 + table[i - 1][j - 1];
                    commonSubSequence.add(charArr1[i - 1]);
                } else table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
            }
        }
        return table[aLen][bLen];
    }

    private static int getLCS(char[] charArr1, char[] charArr2, int aLen, int bLen) {

        if (aLen == 0 || bLen == 0) return 0;

        if (charArr1[aLen - 1] == charArr2[bLen - 1]) {
            commonSubSequence.add(charArr1[aLen - 1]);
            return 1 + getLCS(charArr1, charArr2, aLen - 1, bLen - 1);
        } else
            return Math.max(
                    getLCS(charArr1, charArr2, aLen, bLen - 1),
                    getLCS(charArr1, charArr2, aLen - 1, bLen));
    }
}
