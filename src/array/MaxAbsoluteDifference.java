package array;

import java.util.Arrays;

public class MaxAbsoluteDifference {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1};
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int ans = Math.abs(arr[i] - arr[j])+Math.abs(i-j);
                if (ans > max)
                    max = ans;
            }
        }

        System.out.println("Maximumu absolute difference is : " + max);

        int a = getMin(arr);
        System.out.println(a);

        int s = getMinAns(arr);
        System.out.println(s);
    }

    private static int getMinAns(int[] arr) {
        int min = 0, max = 0, size = arr.length;
        int minI = 0, maxI = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxI = i;
            }

            if (arr[i] < min) {
                min = arr[i];
                minI = i;
            }
        }

        for (int i = 0; i < size; i++) {
            int ans = Math.abs(arr[maxI] - arr[i])+Math.abs(maxI-i);
            if (ans > max)
                max = ans;
        }

        return 0;
    }

    private static int getMin(int[] arr) {
        Arrays.sort(arr);
        return Math.abs(arr[0] - arr[arr.length-1])+Math.abs(arr.length-1);
    }


}
