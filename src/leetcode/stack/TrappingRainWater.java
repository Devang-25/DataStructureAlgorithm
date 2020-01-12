package leetcode.stack;

// Given n non-negative integers representing an elevation map where the width of each bar is 1,
// compute how much water it is able to trap after raining.
// For example, 
// Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

import java.util.Arrays;

import static java.lang.Integer.min;

public class TrappingRainWater {

    public static void main(String[] args) {
        int ar[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(Arrays.toString(ar));
        System.out.println(trap(ar));
        //System.out.println(maxWater(ar));
    }

    public static int trap(int[] height) {
        int trappedWater = 0;
        
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        
        int leftMax = 0;
        int rightMax = 0;
        
        while(leftIndex <= rightIndex) {
            leftMax = Math.max(leftMax, height[leftIndex]);
            rightMax = Math.max(rightMax, height[rightIndex]);
            
            if(leftMax < rightMax) {
                trappedWater += leftMax - height[leftIndex];
                leftIndex++;
            } else {
                trappedWater += rightMax - height[rightIndex];
                rightIndex--;
            }
        }
        return trappedWater;
    }

    public static int maxWater(int arr[]) {
        int result = 0, n = arr.length;

        for (int i = 1; i < n - 1; i++) {
            int left = arr[i];
            for (int j = 0; j < i; j++)
                left = Math.max(left, arr[j]);

            int right = arr[i];
            for (int j = i + 1; j < n; j++)
                right = Math.max(right, arr[j]);

            result = result + (min(left, right) - arr[i]);
        }
        return result;
    }
}

