package javaexamples;

import java.util.Arrays;

/**
 * Created by : Rakesh Gupta on 9/9/17
 * Package : javaexamples
 */
public class Test2 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 3 ,5 ,6 ,4};
        int[] ar = new int[3];
        System.arraycopy(arr, 1, ar, 0, 3);
        System.out.println(Arrays.toString(ar));
    }
}
