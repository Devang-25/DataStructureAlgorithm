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
        System.out.println("Longest Common Sub String(DP) : " + longestCommonSubstringLen);
        System.out.println("Longest Common Sub String(Recursive) "  + longestCommonSubstringRec(str1.toCharArray(), str2.toCharArray(), str1.length()-1, str2.length()-1, false) );

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

    public static int longestCommonSubstringRec(char str1[], char str2[], int pos1, int pos2, boolean checkEqual){
        if(pos1 == -1 || pos2 == -1){
            return 0;
        }
        if(checkEqual){
            if(str1[pos1] == str2[pos2]){
                return 1 + longestCommonSubstringRec(str1, str2, pos1-1, pos2-1, true);
            }else{
                return 0;
            }
        }
        int r1 = 0;
        if(str1[pos1] == str2[pos2]){
            r1 = 1 + longestCommonSubstringRec(str1, str2, pos1-1, pos2-1, true);
        }
        return Math.max(r1,Math.max(longestCommonSubstringRec(str1, str2, pos1-1, pos2, false), longestCommonSubstringRec(str1, str2, pos1, pos2-1,false)));
    }
}
