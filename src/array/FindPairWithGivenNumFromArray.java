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
        int arrSize = A.length;

        if (hasArrayTwoCandidates(A, arrSize, n))
            System.out.println("Array has two elements with sum equal to " + n);
        else
            System.out.println("Array doesn't have two elements with given sum");

    }

    private static boolean hasArrayTwoCandidates(int A[],
                                         int arrSize, int sum) {
        int left, right;

        /* Sort the elements */
        Arrays.sort(A);

        /* Now look for the two candidates
        in the sorted array*/
        left = 0;
        right = arrSize - 1;
        while (left < right) {
            if (A[left] + A[right] == sum)
                return true;
            else if (A[left] + A[right] < sum)
                left++;
            else // A[i] + A[j] > sum
                right--;
        }
        return false;
    }
}
