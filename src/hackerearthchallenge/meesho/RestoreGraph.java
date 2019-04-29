package hackerearthchallenge.meesho;

import java.util.Scanner;

public class RestoreGraph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {

            int n = scanner.nextInt();
            int[][] arr = new int[n][n];
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr[j].length; k++) {
                    arr[j][k] = scanner.nextInt();
                }
            }


            boolean isValid = true;
            out:
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if ((j == k) && (arr[j][k] != 0 || arr[k][j] != 0)) {
                        isValid = false;
                        break out;
                    }

                    for (int l = 0; l < n; l++) {
                        if (l < k)
                            continue;
                        if (arr[k][j] + arr[j][l] <= arr[k][l]) {
                            isValid = false;
                            break out;
                        }
                    }
                }
            }
            System.out.println(isValid ? "YES" : "NO");
        }
    }
}
