package hackerrank.algorithm.implementation;

import java.util.Scanner;

/**
 * Created by rakeshgupta on 9/26/16.
 */
public class DivisibleSumPair {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int i=0; i < n; i++){
            a[i] = in.nextInt();
        }

        int c =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i<j && (a[i]+a[j])%k==0)
                    c++;
            }
        }

        System.out.println(c);

    }
}
