package leetcode.array;


// Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
// For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
// the contiguous subarray [4,-1,2,1] has the largest sum = 6.

public class MaximumSubarray {

    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int ar[] = {-1};
        System.out.println(maxSubArray(ar));
        System.out.println(maxSubArraySum(arr));
    }

    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static int maxSubArraySum(int[] arr) {
        if (arr.length == 0)
            return 0;
        if (arr.length == 1)
            return arr[0];

        int finalMax = arr[0], tempMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            tempMax = Math.max(arr[i], tempMax + arr[i]);
            finalMax = Math.max(tempMax, finalMax);
        }
        return finalMax;
    }
}
