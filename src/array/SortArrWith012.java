package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SortArrWith012 {
    public static void main(String[] args) {
        InputReader sc = new InputReader();
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }

            int count1 = 0, count2 = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == 1)
                    count1++;
                if (arr[j] == 2)
                    count2++;
            }

            for (int j = 0; j < count2; j++) {
                arr[n - 1 - j] = 2;
            }
            for (int j = 0; j < count1; j++) {
                arr[n - count2 - 1 - j] = 1;
            }
            for (int j = 0; j < (n - count1 - count2); j++) {
                arr[j] = 0;
            }

            for (int j = 0; j < n; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }

    static class InputReader {

        BufferedReader br;
        StringTokenizer st;

        public InputReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
