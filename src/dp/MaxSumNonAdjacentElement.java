package dp;

/**
 * Created by : Rakesh Gupta on 8/8/17
 * Package : dp
 */
public class MaxSumNonAdjacentElement {
    public static void main(String[] args) {
        int arr[] = { 2, 10, 13, 4, 2, 15, 10 };

        int ans = getMaxSum(arr);
        System.out.println("Maximum Sum Non Adjacent Element(DP) : " + ans);

        int max = maxSum(arr, arr.length-1);
        System.out.println("Maximum Sum Non Adjacent Element(Recursive Programming) : " + ans);

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


    //Recursive Algorithm
    public static int maxSum(int arr[], int index) {
        if (index == 0) {
            return arr[0];
        } else if (index == 1) {
            return Math.max(arr[0], arr[1]);
        }
        return Math.max(maxSum(arr, index - 2) + arr[index], maxSum(arr, index - 1));
    }
}
