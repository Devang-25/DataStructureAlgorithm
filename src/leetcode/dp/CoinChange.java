package leetcode.dp;

// You are given coins of different denominations and a total amount of money amount.
// Write a function to compute the fewest number of coins that you need to make up that amount.
//
// If that amount of money cannot be made up by any combination of the coins, return -1.

// Example 1:
// coins = [1, 2, 5], amount = 11
// return 3 (11 = 5 + 5 + 1)

// Example 2:
// coins = [2], amount = 3
// return -1.

// Note:
// You may assume that you have an infinite number of each kind of coin.

public class CoinChange {

    public static void main(String[] args) {
        int coins[] = {1, 2, 5, 7};
        System.out.println(minCoinDP(coins, coins.length, 13));
        System.out.println(minCoin(coins, coins.length, 13));

    }

    public static int minCoin(int[] coins, int n, int val) {
        if (val == 0) return 0;

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (coins[i] <= val) {
                int sub_res = minCoin(coins, n, val - coins[i]);
                if (sub_res != Integer.MAX_VALUE)
                    res = Math.min(sub_res + 1, res);
            }
        }
        return res;
    }

    public static int minCoinDP(int[] coins, int n, int val) {
        if (val == 0) return 0;

        int dp[] = new int[val + 1];
        dp[0] = 0;

        for (int i = 1; i <= val; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= val; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i) {
                    int sub_res = dp[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE)
                        dp[i] = Math.min(sub_res + 1, dp[i]);
                }
            }
        }
        // if no coins matches then return Integer.MAX_VALUE or -1
        return dp[val];
    }
}
