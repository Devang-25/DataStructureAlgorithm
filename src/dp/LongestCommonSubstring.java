package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by rakeshgupta on 8/1/17.
 */
public class LongestCommonSubstring {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = bufferedReader.readLine();
        String str2 = bufferedReader.readLine();

        int longestCommonSubstringLen = getLCSubstringLen(str1, str2);
        System.out.println("Longest Common Sub String : " + longestCommonSubstringLen);

    }

    private static int getLCSubstringLen(String str1, String str2) {
        int str1Len = str1.length();
        int str2Len = str2.length();

        int T[][] = new int[str1Len+1][str2Len+1];

        char str1Arr[] = str1.toCharArray();
        char str2Arr[] = str2.toCharArray();

        int max = 0;

        for (int i = 1; i <= str1Len; i++) {
            for (int j = 1; j <= str2Len; j++) {
                if (str1Arr[i-1] == str2Arr[j-1])
                    T[i][j] = 1+ T[i-1][j-1];
                    if (max < T[i][j])
                        max = T[i][j];
            }
        }
        return max;
    }
}
