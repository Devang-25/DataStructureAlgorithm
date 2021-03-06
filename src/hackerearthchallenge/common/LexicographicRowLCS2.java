package hackerearthchallenge.common;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LexicographicRowLCS2 {
    static int count = 0;
    static ArrayList<Integer> ans = new ArrayList<>();

    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        int N = inputReader.nextInt();
        int M = inputReader.nextInt();

        char[][] mat = new char[N][M];
        for (int i = 0; i < N; i++) {
            mat[i] = inputReader.next().toCharArray();
        }
        ans = new ArrayList<>(M);
        int minRowDel = 0;
        for (int i = 0; i < N - 1; i++) {
            int tempMinRowDel = 0;
            String rowStr1 = String.valueOf(mat[i]);
            String rowStr2 = String.valueOf(mat[1 + 1]);
            tempMinRowDel = findMinRowDel(rowStr1, rowStr2);
            if (minRowDel < tempMinRowDel) {
                minRowDel = tempMinRowDel;
            }
        }
        if (minRowDel > M) {
            System.out.println(M);
        }
        System.out.println(minRowDel);
    }

    private static int findMinRowDel(String rowStr1, String rowStr2) {
        isEditDistanceOne(rowStr1, rowStr2);
        return count;
    }

    static void isEditDistanceOne(String s1, String s2) {
        int m = s1.length(), n = s2.length();

        count = 0;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s1.charAt(i) != s2.charAt(j)) {
                i++;
                j++;
                ans.add(i, 1);
                count++;
            } else {
                i++;
                j++;
            }
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

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
