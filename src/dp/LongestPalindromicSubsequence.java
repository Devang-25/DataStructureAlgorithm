package dp;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        //Test String - agbdba
        //Ans - abdba

        String testStr = "agbdba";
        int longestPalindromicSubsequence = getLongestPalindromicSubSequence(testStr);
        System.out.println(" Longest Palindromic Subsequence(DP) : " + longestPalindromicSubsequence);

        int ans = calculateRecursive(testStr.toCharArray(), 0, testStr.length());
        System.out.println(" Longest Palindromic Subsequence(Recursive) : " + ans);
    }

    //Using Dynamic Programming
    private static int getLongestPalindromicSubSequence(String testStr) {
        int n = testStr.length();
        char []strArr = testStr.toCharArray();
        int arr[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            arr[i][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < n - i +1; j++) {
                int k = j + i -1;
                if (i == 2 && strArr[j] == strArr[k]){
                    arr[j][k] = 2;
                }else if (strArr[j] == strArr[k]){
                    arr[j][k] = arr[j+1][k-1]+2;
                }else {
                    arr[j][k] = Math.max(arr[j+1][k], arr[j][k-1] );
                }

            }
        }

        return arr[0][n-1];
    }

    //Using Recursive
    public static int calculateRecursive(char str[],int start,int len){
        if(len == 1){
            return 1;
        }
        if(len ==0){
            return 0;
        }
        if(str[start] == str[start+len-1]){
            return 2 + calculateRecursive(str,start+1,len-2);
        }else{
            return Math.max(calculateRecursive(str, start+1, len-1), calculateRecursive(str, start, len-1));
        }
    }
}
