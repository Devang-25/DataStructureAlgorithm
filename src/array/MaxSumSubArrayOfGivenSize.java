package array;

/**
 * Created by : Rakesh Gupta on 9/8/17
 * Package : array
 */
public class MaxSumSubArrayOfGivenSize {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int size = 4;

        int maxSum = getMaxSum(arr, size);
        System.out.println("Maximum sum of subarray size of array : " + maxSum);
    }

    private static int getMaxSum(int[] arr, int size) {

        if (arr.length < size)
            return Integer.MIN_VALUE;

        int max = 0;
        for (int i = 0; i < size; i++) {
            max += arr[i];
        }

        int curSum = max;
        for (int i = size; i < arr.length; i++) {
            curSum += (arr[i]-arr[i-size]);
            max = Math.max(max, curSum);
        }
        return max;
    }
}
