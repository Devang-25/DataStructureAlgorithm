package hackerearthchallenge;

import java.util.Scanner;

/**
 * Stack and Queue <Nissan>
 *
 * You are given a stack of N integers such that the first element represents the top of the stack and the last element represents the bottom of the stack. You need to pop at least one element from the stack. At any one moment, you can convert stack into a queue. The bottom of the stack represents the front of the queue. You cannot convert the queue back into a stack. Your task is to remove exactly K elements such that the sum of the K removed elements is maximised.
 *
 * Input format :
 *
 *     The first line consists of two space-separated integers N and K.
 *     The second line consists of N space-separated integers denoting the elements of the stack.
 *
 * Output format :
 *
 *     Print the maximum possible sum of the K removed elements
 *
 * Constraints :
 *
 * Sample Input
 *
 * 10 5
 * 10 9 1 2 3 4 5 6 7 8
 *
 * Sample Output
 *
 * 40
 */
public class StackAndQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        int max = 0;
        for (int f=1; f<=K; f++){
            int locaMax = getFirst(f, arr, K);
            if (locaMax > max)
                max = locaMax;
        }
        System.out.println(max);
    }

    private static int getFirst(int k, int[] arr, int K) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int len = arr.length-1;

        for (int i = 0; i < (K-k); i++) {
            sum += arr[len-i];
        }
        return sum;
    }
}
