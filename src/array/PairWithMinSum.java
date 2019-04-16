package array;

import java.util.Arrays;

public class PairWithMinSum {

    public static void main(String[] args) {
        int array[] = {1, 30, -5, 70, -8, 20, -40, 60};
        findPairWithMinSum(array);
    }

    private static void findPairWithMinSum(int[] array) {

        int n = array.length;
        if (n < 0)
            return;

        Arrays.sort(array);

        int sum = 0;
        int minSum = Integer.MAX_VALUE;

        int l = 0, r = n - 1;

        int minLeft = l, minRight = n - 1;


        while (l < r) {
            sum = array[l] + array[r];
            if (Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum;
                minLeft = l;
                minRight = r;
            }

            if (sum < 0)
                l++;
            else
                r--;
        }
        System.out.println(" The pair with min sum : " + array[minLeft] + " " + array[minRight]);
    }
}
