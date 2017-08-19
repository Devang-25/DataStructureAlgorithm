package array;

/**
 * Created by : Rakesh Gupta on 8/20/17
 * Package : array
 */
public class MaxSumFromTopToBottomMatrix {
    public static void main(String[] args) {
        int [][] matrix =
                      { {2,3,4,1},
                        {1,1,3,9},
                        {2,2,3,1},
                        {2,2,3,1}
                     };

        int maxSum = getMaxSumMatrix(matrix);
        System.out.println("Maximum sum from top to bottom in matrix : " + maxSum);
    }

    private static int getMaxSumMatrix(int[][] sum) {

        for (int i = 1; i < sum.length; i++) {
            sum[i][0] += sum[i-1][0];
        }

        for (int i = 1; i < sum[0].length; i++) {
            sum[0][i] += sum[0][i-1];
        }

        for (int i = 1; i < sum.length; i++) {
            for (int j = 1; j < sum[0].length; j++) {
                sum[i][j] += Math.max(sum[i-1][j], sum[i][j-1]);
            }
        }

        return sum[sum.length-1][sum[0].length-1];
    }
}
