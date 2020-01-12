package leetcode.array;


// Find the contiguous subarray within an array (containing at least one number) which has the largest product.
// For example, given the array [2,3,-2,4],
// the contiguous subarray [2,3] has the largest product = 6.

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ans, max, min;
        ans = min = max = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int tempMax = nums[i] * max;
            int tempMin = nums[i] * min;

            max = Math.max(Math.max(tempMax, tempMin), nums[i]);
            min = Math.min(Math.min(tempMax, tempMin), nums[i]);

            if (max > ans) {
                ans = max;
            }
        }
        return ans;
    }
}
