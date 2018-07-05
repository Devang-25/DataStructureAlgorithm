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
        int arr[] = new int[]{3,-4, 6, -7, 0, 1};
        System.out.println(getMaxValue(arr));


    }

  /**
   * This will return max possible sum of consecutive numbers.
   * @param arr
   * @return
   */
  public static int getMaxValue(int[] arr) {
        int size = arr.length;
        int finalMax = Integer.MIN_VALUE, maxTemp = 0;

        for (int i=0; i< size; i++){
                maxTemp = maxTemp + arr[i];
                if (finalMax < maxTemp)
                    finalMax = maxTemp;
                if (maxTemp < 0)
                    maxTemp = 0;
        }
    return finalMax;
    }
}
