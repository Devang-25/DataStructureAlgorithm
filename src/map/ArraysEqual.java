package map;

import java.util.HashMap;

/**
 * Created by rakeshgupta on 7/19/17.
 */
public class ArraysEqual {
    public static void main(String[] args) {
        int arr1[] = new int[]{ 3, 5, 4, 7};
        int arr2[] = new int[]{ 3, 5, 4, 7};
        System.out.println(getEqualityOfArrays(arr1, arr2));
    }

    private static boolean getEqualityOfArrays(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < arr1.length; i++) {
            //int temp = hashMap.get()
        }
        return false;
    }
}
