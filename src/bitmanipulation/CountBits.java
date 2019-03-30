package bitmanipulation;

/**
 * Created by rakeshgupta on 7/15/17.
 */

import java.util.Scanner;

class CountBits {
    public static void main(String args[]) {
        int count=0;
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i=0;i < T;i++)
        {
            int N = s.nextInt();
            count = countSetBit(N);
            System.out.println(count);
        }
    }

    private static int countSetBit(int N) {
        int count = 0;
        while (N != 0) {
            int x = N % 2;
            N = N / 2;
            if (x == 1)
                count++;
        }
        return count;
    }

    private static int countSetBit2(int N) {
        int count = 0;
        while (N > 0) {
            count += N & 1;
            N >>= 1;
        }
        return count;
    }

    private static int countSetBit3(int N) {
        int count = 0;
        while (N > 0) {
            N &= (N - 1);
            count++;
        }
        return count;
    }

}