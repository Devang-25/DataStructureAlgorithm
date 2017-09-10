package bitmanipulation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by : Rakesh Gupta on 9/9/17
 * Package : bitmanipulation
 */
public class SubArraySolution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int i = 0; i < T; i++) {

            int N = input.nextInt();
            int M = input.nextInt();
            int P = input.nextInt();

            int[] arr = new int[N];

            for (int j = 0; j < N; j++) {
                arr[j] = input.nextInt();
            }

            int smallestMXOR = 0, highestPXOR = 0, finalAns = 0, max=0, maxL=0, maxR=0, smallL = 0, maxLen = 0;

            for (int r = 0; r < N; r++) {

                for (int l = 0; l < (N-M+1) || l < (N-P+1); l++) {

                    if (r-l >= M-1 && r-l >= P-1 && r>=P && l<r ) {
                        smallestMXOR = getFirstSmallestXOR(arr, r, l, M);
                        highestPXOR = getSecondHighestXOR(arr, r, l, P);
                        finalAns = smallestMXOR & highestPXOR;
                        if (finalAns > max) {
                            max = finalAns;
                            maxR = r;
                            maxL = l;
                            maxLen = r-l;
                            smallL = r;
                        }else if (finalAns == max){
                            if (r-l>maxLen){
                                maxR = r;
                                maxL = l;
                            }else if (smallL < r){
                                maxR = r;
                                maxL = l;
                            }
                        }
                    }

                }
            }
            System.out.println( (maxL+1) + " " + (maxR+1) + " " + max);
        }
    }

    private static int getSecondHighestXOR(int[] arrOriginal, int r, int l, int p) {
        int[] arr = new int[r-l+1];
        System.arraycopy(arrOriginal, l, arr, 0, r-l+1);
        Arrays.sort(arr);
        int s = arr.length;

        int sum = arr[s-1];
        if (p == 1)
            return sum;

        for (int i = s-2; i > (s-p-1) ; i--) {
            sum ^= arr[i];
        }
        return sum;
    }

    private static int getFirstSmallestXOR(int[] arrOriginal, int r, int l, int m) {
        int[] arr = new int[r-l+1];
        System.arraycopy(arrOriginal, l, arr, 0, r-l+1);
        Arrays.sort(arr);
        int sum = arr[0];
        if (m == 1)
            return sum;

        for (int i = 1; i < m; i++) {
            sum ^= arr[i];
        }
        return sum;
    }

}
