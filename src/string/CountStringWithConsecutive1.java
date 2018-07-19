package string;

/******************************************************************************
 * Copyright (c) ::                                                           *
 * Creation Date - 19:7:2018,                                                 *
 * Created by - Rakesh Gupta,                                                 *
 * Package - string.CountStringWithConsecutive1                               *
 * Last modified - 7/19/18 11:56 AM                                           *
 * Project Name - DataStructureAlgorithm                                      *
 ******************************************************************************/

public class CountStringWithConsecutive1 {
    public static void main(String[] args) {
        System.out.println(countStrings(5));
    }

    // Returns count of n length binary strings with consecutive 1's
    static int countStrings(int n) {

        // Count binary strings without consecutive 1's.

        int a[] = new int[n], b[] = new int[n];
        a[0] = b[0] = 1;

        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }

        // Subtract a[n-1]+b[n-1] from 2 ^ n
        return (1 << n) - a[n - 1] - b[n - 1];
    }
}
