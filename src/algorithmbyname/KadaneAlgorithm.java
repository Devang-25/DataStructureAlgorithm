package algorithmbyname;

/**
 * Created by rakeshgupta on 7/20/17.
 */

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
