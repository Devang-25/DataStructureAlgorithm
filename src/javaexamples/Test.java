package javaexamples;

import java.io.*;
import java.util.*;

public class Test {
    static long getMaxPairwiseProducts(int[] numbers) {

        long maxFirst = Long.MIN_VALUE;
        long maxSecond = Long.MIN_VALUE;
        int index = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > maxFirst) {
                maxFirst = numbers[i];
                index = i;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if ( numbers[i] > maxSecond && i != index )
                maxSecond = numbers[i];
        }
        return maxFirst*maxSecond;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProducts(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}