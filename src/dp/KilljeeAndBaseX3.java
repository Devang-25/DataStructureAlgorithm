package dp;

import java.util.Scanner;

/**
 * Created by rakeshgupta on 7/30/17.
 */

public class KilljeeAndBaseX3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        for (int i = 0; i < t; i++) {

            long n = input.nextLong();
            int k = input.nextInt();
            System.out.println(solve(k, n));
        }
    }

    static long solve(int k, long n){

        long longBit = getBitLenth(n,k);
        long halfAns = getTotalBit2(longBit-1, k);

//        long pawAns = (long) Math.pow(k, longBit-1);
//        long remainAns = (n-pawAns+1)*longBit;
//
        StringBuilder nn = new StringBuilder("1");
        for (int i = 0; i < longBit-1; i++) {
            nn.append(""+0);
        }
        int baseNum = Integer.parseInt(nn.toString(), k);
        int remainAns = (int) ((n-baseNum+1)*longBit);

        System.out.println(halfAns + "  " + remainAns);
        return (halfAns+remainAns);
    }

    private static long getBitLenth(long n, int k) {
        long count = 0;
        while (n > 0){
            n = (n/k);
            count++;
        }
        System.out.println("bit " + count);
        return count;
    }

    private static long getTotalBit2(long num, int k) {

        if (num == 1.0)
            return k;

        long temp = k , total = 0;

        for (int i = 2; i <= num; i++) {
            total = (2*k*temp) - temp;
            temp = total;
        }
        return total;
    }
}
