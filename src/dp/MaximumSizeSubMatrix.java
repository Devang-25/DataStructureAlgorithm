package dp;

/**
 * Created by : Rakesh Gupta on 8/7/17
 * Package : dp
 */
public class MaximumSizeSubMatrix {
    public static void main(String[] args) {
        int arr[][] = {{0,1,1,0,1},{1,1,1,0,0},{1,1,1,1,0},{1,1,1,0,1}};
        int result = getMaxSizeSubMatrix(arr);
        System.out.println(" Maximum Size Sub Matrix : " + result);
    }

    private static int getMaxSizeSubMatrix(int[][] arr) {
        int result[][] = new int[arr.length][arr[0].length];
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            result[i][0]  = arr[i][0];
            if (result[i][0] == 1)
                max = 1;
        }

        for (int i = 0; i < arr[0].length; i++) {
            result[0][i] = arr[0][i];
            if (result[0][i] == 1)
                max = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if (arr[i][j] == 0)
                    continue;
                int t = getMin(result[i-1][j], result[i-1][j-1], result[i][j-1]);
                result[i][j] = t + 1;
                if (result[i][j] > max)
                    max = result[i][j];
            }
        }
        return max;
    }

    private static int getMin(int i, int i1, int i2) {
        int k = Math.min(i, i1);
        return Math.min(k, i2);
    }
}
