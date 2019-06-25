package hackerearthchallenge.common;

import java.util.Scanner;

public class Test {
    static String X = "";
    static String Y = "";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
                X = scanner.nextLine();
        Y = scanner.nextLine();
        int m = X.length();
        int n = Y.length();

        System.out.println(lcs(n, m, 0));
    }

    static int lcs(int i, int j, int count) {

        if (i == 0 || j == 0) {
            return count;
        }

        if (X.charAt(i - 1) == Y.charAt(j - 1)) {
            count = lcs(i - 1, j - 1, count + 1);
        }
        count = Math.max(count, Math.max(lcs(i, j - 1, 0),
                lcs(i - 1, j, 0)));
        return count;
    }
}