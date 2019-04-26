package hackerearthchallenge.payu;

import java.util.Scanner;

public class GoodSubSequenceSolution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = scanner.nextInt();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            stringBuffer.append(scanner.nextInt());
        }
        if (n == 0) {
            System.out.println(0);
            return;
        }

        int ans = findOccurrences(s, stringBuffer.toString());
        System.out.println(ans);
    }


    public static int findOccurrences(String str1, String substr1) {
        int n = str1.length();

        char[] str = str1.toCharArray();
        char[] substr = substr1.toCharArray();

        int[] preLeft = new int[n];
        int[] preRight = new int[n];

        if (str[0] == substr[0])
            preLeft[0]++;

        for (int i = 1; i < n; i++) {
            if (str[i] == substr[0])
                preLeft[i] = preLeft[i - 1] + 1;
            else
                preLeft[i] = preLeft[i - 1];
        }

        if (str[n - 1] == substr[2])
            preRight[n - 1]++;

        for (int i = n - 2; i >= 0; i--) {
            if (str[i] == substr[2])
                preRight[i] = preRight[i + 1] + 1;
            else
                preRight[i] = preRight[i + 1];
        }
        int counter = 0;

        for (int i = 1; i < n - 1; i++) {
            if (str[i] == str[1]) {
                int total = preLeft[i - 1] * preRight[i + 1];
                counter += total;
            }
        }
        return counter;
    }
}
