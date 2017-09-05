package arithmetic;

import java.util.Arrays;

/**
 * Created by : Rakesh Gupta on 9/6/17
 * Package : arithmetic
 */
public class MinXORValueArray {
    public static void main(String[] args) {
        int[] arr = {2, 0, 5, 8, 6, 9};

        int minXORValue = getMinXORValue(arr);
        System.out.println("Min XOR Value is : " + minXORValue);
    }

    private static int getMinXORValue(int[] arr) {

        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;

        for (int size = arr.length,i = 0; i < size-1; i++) {
            min = Math.min(min, arr[i]^arr[i+1]);
        }

        return min;
    }
}
