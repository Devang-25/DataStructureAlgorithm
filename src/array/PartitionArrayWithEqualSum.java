package array;

import java.util.Scanner;

public class PartitionArrayWithEqualSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            if (n == 1) {
                System.out.println(1);
                continue;
            }
            int idx = equilibriumPoint(arr, arr.length);
            System.out.println(idx);
        }
    }

    static int equilibriumPoint(int[] arr, int size) {
        int[] preSum = new int[size];
        preSum[0] = arr[0];
        for (int i = 1; i < size; i++) {
            preSum[i] = preSum[i - 1] + arr[i];
        }
        for (int i = 0; i < size; i++) {
            if (preSum[i] - arr[i] == preSum[size - 1] - preSum[i]) {
                return i + 1;
            }
        }
        return -1;
    }

    private static int findPartitionPoint(int[] arr) {
        int idx = 0, len = 2;
        int low = 0, high = arr.length - 1;
        int fSum = arr[low], lSum = arr[high];
        while (low <= high) {
            if (fSum == lSum && len == arr.length - 1) {
                return low;
            } else if (fSum > lSum) {
                high--;
                lSum += arr[high];
            } else if (fSum < lSum) {
                low++;
                fSum += arr[low];
            }
            len++;
        }
        return idx;
    }
}
