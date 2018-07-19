package string;

/******************************************************************************
 * Copyright (c) ::                                                           *
 * Creation Date - 19:7:2018,                                                 *
 * Created by - Rakesh Gupta,                                                 *
 * Package - string.CountNumberOfBinaryStringWithoutConsecutive1              *
 * Last modified - 7/19/18 11:57 AM                                           *
 * Project Name - DataStructureAlgorithm                                      *
 ******************************************************************************/

public class CountNumberOfBinaryStringWithoutConsecutive1 {

    public static void main(String[] args) {
        System.out.println(countStrings(4));
    }

    static int countStrings(int n) {
        int a[] = new int[n];
        int b[] = new int[n];
        a[0] = b[0] = 1;

        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }
        return a[n - 1] + b[n - 1];
    }
}
