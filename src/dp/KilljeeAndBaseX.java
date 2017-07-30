package dp;

import java.util.Scanner;

/**
 * Created by rakeshgupta on 7/29/17.
 */
public class KilljeeAndBaseX {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        for (int i = 0; i < t; i++) {

            double n = input.nextDouble();
            int k = input.nextInt();

            double longBit = (n/k);
            if (longBit == (int)(n/k)){
                longBit++;
            }else {
                longBit = (int)(n/k);
            }

            double halfAns = getTotalBit2(longBit-1, k);

//            double lastNum = n/(double)k;

            double pawAns = Math.pow(k, longBit-1);

            double remainAns = (n-pawAns+1)*longBit;
            System.out.println("half Ans : " + halfAns);
            System.out.println("Remain Ans :" + remainAns);
            System.out.println("Total digit : " + (halfAns+remainAns));
        }
    }

    private static double getTotalBit(double num, int k) {

        System.out.println("Num : " +num + " k : " + k);

        double arr[] = new double[(int)(num+1)];
        arr[0] = 1;

        if (num == 0.0)
            return k;

        arr[1] = k;

        for (int i = 2; i <= num; i++) {
            arr[i] = (2*k*arr[i-1]) - arr[i-1];
        }

        return arr[((int) num)];
    }

    private static double getTotalBit2(double num, int k) {

        System.out.println("Num : " +num + " k : " + k);

        if (num == 0.0 || num == 1.0)
            return k;

        double temp = k , total = 0;

        for (int i = 2; i <= num; i++) {
            total = (2*k*temp) - temp;
            if (total == 50)
                System.out.println("500000");
            temp = total;
        }

        return total;
    }


}
