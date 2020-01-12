package array;

import java.util.Arrays;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        int arr[] = {1, -2, -3, 0, 7, -8, -2};
        System.out.println(Arrays.toString(arr));
        System.out.println("Maximum Sub array product is " + maxSubarrayProduct(arr));
    }

    private static int maxSubarrayProduct(int arr[]) {

        int n = arr.length;
        // max positive product ending at the current position
        int currMax = 1;

        // min negative product ending at the current position
        int currMin = 1;

        // Initialize overall max product
        int finalMax = 1;

        /* Traverse through the array. Following values are maintained after the ith iteration:
        currMax is always 1 or some positive product ending with arr[i]
        currMin is always 1 or some negative product ending with arr[i] */
        for (int i = 0; i < n; i++) {
            /* If this element is positive, update currMax.
            Update currMin only if currMin is
            negative */
            if (arr[i] > 0) {
                currMax = currMax * arr[i];
                currMin = min(currMin * arr[i], 1);
            }

            /* If this element is 0, then the maximum product cannot
             end here, make both currMax and min_ending
            _here 0
             Assumption: Output is alway greater than or equal to 1. */
            else if (arr[i] == 0) {
                currMax = 1;
                currMin = 1;
            }

            /* If element is negative. This is tricky
            currMax can either be 1 or positive.
            currMin can either be 1 or negative.
            next currMin will always be prev.
            currMax * arr[i]
            next currMax will be 1 if prev
            currMin is 1, otherwise
            next currMax will be
                        prev currMin * arr[i] */
            else {
                int temp = currMax;
                currMax = max(currMin * arr[i], 1);
                currMin = temp * arr[i];
            }

            // update finalMax, if needed
            if (finalMax < currMax) finalMax = currMax;
        }

        return finalMax;
    }
}
