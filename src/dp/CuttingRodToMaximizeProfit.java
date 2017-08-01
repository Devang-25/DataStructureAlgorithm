package dp;

/**
 * Created by rakeshgupta on 8/1/17.
 */
public class CuttingRodToMaximizeProfit {
    public static void main(String[] args) {
        int rodValue[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        int len = rodValue.length;

        int maxProfit = getMaxProfit(rodValue, len);
        System.out.println("Maximum obtainable value is(Using Recursion) : " + maxProfit);
        System.out.println("Maximum obtainable value is(Using Dynamic Programming) : " + getMaximumProfit(rodValue, len));
    }

    // Without using dynamic programming
     static int getMaxProfit(int[] rodValue, int len) {

        if (len <= 0)
            return 0;

        int maxValue = Integer.MIN_VALUE;
         for (int i = 0; i < len; i++) {
             maxValue = Math.max(maxValue, rodValue[i] + getMaxProfit(rodValue, len-i-1));
         }
         return maxValue;
    }

    // Using dynamic programming
    static int getMaximumProfit(int rodValue[], int n){
        int val[] = new int[n+1];
        val[0] = 0;

        for (int i = 1; i <= n; i++) {
            int maxValue = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                maxValue = Math.max(maxValue, rodValue[j]+val[i-j-1]);
                val[i] = maxValue;
            }
        }

        return val[n];
    }
}
