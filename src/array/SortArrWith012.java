package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
            System.out.println("Before sorting : " + Arrays.toString(arr));
            //sortArrWith012(arr);
            sortArrWith012WithoutCount(arr);
            System.out.println("After sorting : " + Arrays.toString(arr));
        }
    }

    private static void sortArrWith012WithoutCount(int[] arr) {
        int low = 0, high = arr.length - 1, mid = 0, temp = 0;
        while (mid <= high) {
            switch (arr[mid]) {
                case 0: {
                    temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                    break;
                }
                case 1: {
                    mid++;
                    break;
                }
                case 2: {
                    temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;
                    high--;
                    break;
                }
            }
        }
        StringBuffer out = new StringBuffer();
        for (int j = 0; j < arr.length; j++) {
            out.append(arr[j] + " ");
        }
        System.out.println(out.toString());
    }

    private static void sortArrWith012(int[] arr) {
        int n = arr.length;
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
