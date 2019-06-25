package algorithmbyname;

/******************************************************************************
 * Copyright (c) ::                                                           *
 * Creation Date - 5:7:2018,                                                  *
 * Created by - Rakesh Gupta,                                                 *
 * Package - algorithmbyname.KadaneAlgorithm                                  *
 * Last modified - 7/5/18 11:58 AM                                            *
 * Project Name - DataStructureAlgorithm                                      *
 ******************************************************************************/

public class KadaneAlgorithm {
    public static void main(String[] args) {
        int arr[] = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " + getMaxValue(arr));
    }

    /**
     * This will return max possible sum of consecutive numbers.
     *
     * @param arr
     * @return
     */
    public static int getMaxValue(int[] arr) {
        int size = arr.length;
        int finalMax = Integer.MIN_VALUE, maxTemp = 0;
        int start = 0, end = 0, s = 0;

        for (int i = 0; i < size; i++) {
            maxTemp = maxTemp + arr[i];
            if (finalMax < maxTemp) {
                finalMax = maxTemp;
                start = s;
                end = i;
            }
            if (maxTemp < 0) {
                maxTemp = 0;
                s = i + 1;
            }
        }
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);
        return finalMax;
    }
}
