package array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by rakeshgupta on 8/2/17.
 */

public class MaxSumInLongestOfIncreasingSubSequence {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int arr[] = new int[]{
                1, 3, 5, 2, 4, 9, 11, 6
        };

//         new int[s.nextInt()];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = s.nextInt();
//        }
        System.out.println("Maximum sum increasing sub-sequence : " + getMaxSumOfLongestIncreasingSubSeq(arr));
    }

    private static int getMaxSumOfLongestIncreasingSubSeq(int[] arr) {

        int subSeqArrSum[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            subSeqArrSum[i] = arr[i];
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && (subSeqArrSum[i] < subSeqArrSum[j] + arr[i])) {
                    subSeqArrSum[i] = subSeqArrSum[j] + arr[i];
                }
            }
        }
        return Arrays.stream(subSeqArrSum).max().getAsInt();
    }
}
