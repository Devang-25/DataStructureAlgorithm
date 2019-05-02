package array;

import java.util.Scanner;

public class MaximumOfAllSubArrays {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int q = s.nextInt();
        for (int i = 0; i < q; i++) {
            int size = s.nextInt();
            int k = s.nextInt();

            int arr[] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = s.nextInt();
            }
            printMaxOfAllSubArray(arr, k);
        }
    }

    private static void printMaxOfAllSubArray(int[] arr, int k) {
        int ans[] = new int[arr.length - k + 1];
        int maxSum = getMaxArray(arr, 0, k);
        ans[0] = maxSum;
        for (int i = k; i < arr.length; i++) {
            if (arr[i - k] != maxSum) {
                maxSum = Math.max(maxSum, arr[i]);
            } else {
                maxSum = getMaxArray(arr, i - k, i);
            }
            ans[i - k + 1] = maxSum;
        }
        StringBuffer out = new StringBuffer(ans.length);
        for (int i = 0; i < ans.length; i++) {
            out.append(ans[i] + " ");
        }
        System.out.println(out.toString());
    }

    private static int getMaxArray(int[] arr, int fromNum, int toNum) {
        int max = arr[fromNum + 1];
        for (int i = fromNum + 1; i <= toNum; i++) {
            max = Math.max(arr[i], max);
        }
        return max;
    }
}
