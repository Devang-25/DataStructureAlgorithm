package array;

import java.util.Arrays;

/******************************************************************************
 * Copyright (c) ::                                                           *
 * Creation Date - 18:7:2018,                                                 *
 * Created by - Rakesh Gupta,                                                 *
 * Package - array.FindPairWithGivenNumFromArray                              *
 * Last modified - 7/18/18 11:54 AM                                           *
 * Project Name - DataStructureAlgorithm                                      *
 ******************************************************************************/

public class FindPairWithGivenNumFromArray {

    public static void main(String[] args) {

        int A[] = {1, 4, 45, 6, 10, -8};
        int n = 16;
        int arr_size = A.length;

        if (hasArrayTwoCandidates(A, arr_size, n))
            System.out.println("Array has two elements with sum equal to " + n);
        else
            System.out.println("Array doesn't have two elements with given sum");

    }

    private static boolean hasArrayTwoCandidates(int A[],
                                         int arr_size, int sum) {
        int l, r;

        /* Sort the elements */
        Arrays.sort(A);

        /* Now look for the two candidates
        in the sorted array*/
        l = 0;
        r = arr_size - 1;
        while (l < r) {
            if (A[l] + A[r] == sum)
                return true;
            else if (A[l] + A[r] < sum)
                l++;
            else // A[i] + A[j] > sum
                r--;
        }
        return false;
    }
}
