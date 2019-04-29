package hackerearthchallenge.meesho;

import java.math.BigInteger;
import java.util.Scanner;

public class ArrayPartition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long arr[] = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }

        int start = 0, end = n - 1, idx = 0;
        BigInteger fSum = BigInteger.valueOf(arr[start]);
        BigInteger lSum = BigInteger.valueOf(arr[end]);
        int l = 2;
        do {
            int diff = fSum.compareTo(lSum);

            if (diff == 0 || diff > 0) {
                end--;
                idx = Math.min(start, end);
                lSum = lSum.multiply(BigInteger.valueOf(arr[end]));
            } else if (diff < 0 && arr[start + 1] != 1) {
                start++;
                idx = Math.min(start, end);
                fSum = fSum.multiply(BigInteger.valueOf(arr[start]));
            }
            l++;
            if (l == n) {
                idx = Math.min(start, idx);
                break;
            }
        } while (start <= end || l <= n);
        System.out.println(idx + 1);
    }
}



