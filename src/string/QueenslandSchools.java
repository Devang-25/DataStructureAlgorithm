package string;

import java.util.Scanner;

/**
 * Created by rakeshgupta on 7/2/17.
 */
public class QueenslandSchools {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        int N = scanner.nextInt();

        int arrB[] = new int[N];
        int arrA[] = new int[N];

        for (int i=0; i<N; i++){
            arrA[i] = scanner.nextInt();
            arrB[i] = scanner.nextInt();
        }

        System.out.println(getMaximumB(arrB, arrA, X));
    }

    private static int getMaximumB(int[] arrA, int[] arrB, int totalSum) {
        int n = arrB.length;
        int [] dp = new int[totalSum+1];
        dp[0] = 0;
        for(int i=0; i<=totalSum; i++){
            for(int j=0; j<n; j++){
                if (arrB[j] <= i)
                    dp[i] = Math.max(dp[i], dp[i-arrB[j]]+arrA[j]);
                }
            }
            return dp[totalSum];
    }
}
