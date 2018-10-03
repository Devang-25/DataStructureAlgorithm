package hackerearthchallenge.common;

import java.util.Scanner;

/**
 * You are given an array A of length N. You have to choose a subset S from given array A,
 * such that average of S is less than K. You need to print the maximum possible length of S.
 *
 * Input format :
 *
 *     The first line of each input contains  N, length of array A.
 *     Next line contains N space separated elements of array A.
 *     Next line of input contains an integer Q, Number of queries.
 *     Each following Q  lines contains a single integer K.
 *
 * Output format :
 *
 *     For each query, print single integer denoting the maximum possible length of the subset.
 *
 * Constraints :
 *
 *
 * Sample Input
 *
 * 5
 * 1 2 3 4 5
 * 5
 * 1
 * 2
 * 3
 * 4
 * 5
 *
 * Sample Output
 *
 * 0
 * 2
 * 4
 * 5
 * 5
 */
public class HighestAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        int Q = scanner.nextInt();
        for (int i = 0; i < Q; i++) {
            int K = scanner.nextInt();

        }

    }
}



































