package array;

import java.util.Arrays;

public class FilterZeroFromArray {
    public static void main(String[] args) {
        int ar[] = moveZerosToEnd(new int[]{
                1, 10, 0, 2, 8, 3, 0, 0, 6, 4, 0, 5, 7, 0
        });
        System.out.println(Arrays.toString(ar));
    }

    static int[] moveZerosToEnd(int[] arr) {
        // your code goes here
        int arrSize = arr.length;
        int j = 0;
        int tempArr[] = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            if (arr[i] == 0) {
                while (i < (arrSize - 1) && arr[i] == 0) {
                    i++;
                }
            }
            tempArr[j] = arr[i];
            j++;
        }
        arr = tempArr;
        return arr;
    }
}
