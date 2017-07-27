package dp;

import java.util.Arrays;

/**
 * Created by rakeshgupta on 7/27/17.
 */
public class MinCoinNumberToGetNumber {
    public static void main(String[] args) {
        int coins[] = {3,4,6,7,9};
        int total = 15;

        int minCoinsNumber = getMinCoinNumber(coins, total);
        System.out.println(minCoinsNumber);
    }

    private static int getMinCoinNumber(int[] coins, int total) {
        int T[] = new int[total + 1];
        int R[] = new int[total + 1];
        T[0] = 0;
        for(int i=1; i <= total; i++){
            T[i] = Integer.MAX_VALUE-1;
            R[i] = -1;
        }
        for(int j=0; j < coins.length; j++){
            for(int i=1; i <= total; i++){
                if(i >= coins[j]){
                    if (T[i - coins[j]] + 1 < T[i]) {
                        T[i] = 1 + T[i - coins[j]];
                        R[i] = j;
                    }
                }
            }
        }
        printCoinCombination(R, coins);
        return T[total];
    }

    private static void printCoinCombination(int R[], int coins[]) {
        if (R[R.length - 1] == -1) {
            System.out.print("No solution is possible");
            return;
        }
        int start = R.length - 1;
        System.out.print("Coins used to form total ");
        while ( start != 0 ) {
            int j = R[start];
            System.out.print(coins[j] + " ");
            start = start - coins[j];
        }
        System.out.print("\n");
    }
}
