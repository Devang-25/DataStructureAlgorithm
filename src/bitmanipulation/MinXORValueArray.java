package bitmanipulation;

import java.util.ArrayList;
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

        ArrayList a = new ArrayList();
        a.add(2);
        a.add(0);
        a.add(5);
        a.add(8);
        a.add(6);
        a.add(9);

        int ans = getMinXORValue2(a);
        System.out.println(ans);
    }

    private static int getMinXORValue(int[] arr) {

        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;

        for (int size = arr.length, i = 0; i < size - 1; i++) {
            min = Math.min(min, arr[i] ^ arr[i + 1]);
        }

        return min;
    }


    private static int getMinXORValue2(ArrayList arr) {

        arr.sort(null);
        int min = Integer.MAX_VALUE;
        int size = arr.size();
        for (int i = 0; i < size - 1; i++) {
            min = Math.min(min, (((int) arr.get(i)) ^ ((int) arr.get(i + 1))));
        }
        return min;
    }

}
