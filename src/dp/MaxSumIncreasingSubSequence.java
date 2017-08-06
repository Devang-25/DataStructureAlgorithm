package dp;

/**
 * Created by : Rakesh Gupta on 8/7/17
 * Package : dp
 */
public class MaxSumIncreasingSubSequence {
    public static void main(String[] args) {
        int arr[] = {1, 101, 10, 2, 3, 100,4};
        int result = getMaxSumIncreasingSubSequxence(arr);
        System.out.println(" Maximum Sum increasing Sub Sequence : " + result);
    }

    private static int getMaxSumIncreasingSubSequxence(int[] arr) {
        int maxArr[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
                maxArr[i] = arr[i];
        }

        for (int i = 1; i < maxArr.length ; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i])
                    maxArr[i] = Math.max(maxArr[i], maxArr[j]+arr[i]);
            }
        }

        int max = maxArr[0];
        for (int i = 0; i < maxArr.length; i++) {
            if (maxArr[i] > max)
                max = maxArr[i];
        }
        return max;
    }
}
