package dp;

/**
 * Created by : Rakesh Gupta on 8/8/17
 * Package : dp
 */
public class MaxSumNonAdjacentElement {
    public static void main(String[] args) {
        int arr[] = { 2, 10, 13, 4, 2, 15, 10 };

        int ans = getMaxSum(arr);
        System.out.println("Maximum Sum Non Adjacent Element : " + ans);
    }

    //Using Dynamic Programming
    private static int getMaxSum(int[] arr) {
        int exl = 0;
        int inc = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int temp = inc;
            inc = Math.max(exl+arr[i], inc);
            exl = temp;
        }
        return inc;
    }
}
