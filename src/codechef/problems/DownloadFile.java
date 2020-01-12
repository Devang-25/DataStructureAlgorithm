package codechef.problems;

import java.util.Scanner;

public class DownloadFile {
    private static long totalSum = 0;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            totalSum = 0;
            int n = scan.nextInt();
            int k = scan.nextInt();

            for (int i = 0; i < n; i++) {
                int time = scan.nextInt();
                int data = scan.nextInt();
                if (k - time >= 0) {
                    k = k - time;
                } else if (k - time < 0 && k != 0) {
                    getTotalCost(Math.abs(k - time), data);
                    k = 0;
                } else if (k == 0) {
                    getTotalCost(time, data);
                }
            }
            System.out.println(totalSum);
        }
    }

    private static void getTotalCost(long abs, long data) {
        totalSum = totalSum + (abs * data);
    }
}
