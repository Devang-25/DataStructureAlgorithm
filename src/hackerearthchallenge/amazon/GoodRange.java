package hackerearthchallenge.amazon;

import java.util.Scanner;

public class GoodRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int min = scanner.nextInt();
        int max = -1;

        StringBuffer out = new StringBuffer();
        out.append((n+1) + "\n");

        for (int i = 1; i < q; i++) {
            int temp = scanner.nextInt();
            if (temp > max){
                max = temp;
            } else if (temp < min){

            } else if (temp > min && temp < max){

            }


        }
    }
}
