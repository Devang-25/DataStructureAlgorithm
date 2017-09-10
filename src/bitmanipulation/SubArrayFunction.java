package bitmanipulation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by : Rakesh Gupta on 9/9/17
 * Package : bitmanipulation
 */
public class SubArrayFunction {
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

            int f1XOR = 0, f2XOR = 0, f3Ans = 0, max=0, maxL=0, maxR=0, smallL = 0, maxLen = 0;

            for (int j = 0; j < N; j++) {

                for (int k = 0; k < (N-M+1) || k < (N-P+1); k++) {

                    if (j-k >= M-1 && j-k >= P-1 && j>=P && k<j ) {
                        Arrays.sort(arr, k, j);
                        f1XOR = getFirstXOR(arr, j, k, M);
                        f2XOR = getSecondXOR(arr, j, k, P);
                        f3Ans = f1XOR & f2XOR;
                        if (f3Ans > max) {
                            max = f3Ans;
                            maxR = j;
                            maxL = k;
                            maxLen = j-k;
                            smallL = k;
                        }else if (f3Ans == max){
                                if (j-k>maxLen){
                                    maxR = j;
                                    maxL = k;
                                }else if (k < smallL){
                                  maxR = j;
                                  maxL = k;
                                }
                        }
                    }

                }
            }
            System.out.println( (maxL+1) + " " + (maxR+1) + " " + max);
        }
    }

    private static int getSecondXOR(int[] arr, int r, int l, int p) {
        int sum = arr[r];
        if (p == 1)
            return sum;

        for (int i = r-1; i > r-p ; i--) {
            sum ^= arr[i];
        }
        return sum;
    }

    private static int getFirstXOR(int[] arr, int r, int l, int m) {
        int sum = arr[l];
        if (m == 1)
            return sum;

        for (int i = l+1; i < l+m; i++) {
            sum ^= arr[i];
        }
        return sum;
    }

}
