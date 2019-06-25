package array;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArray {

  public static void main(String[] args) {

    int arr[] = {1, 0, 0, 1, 0, 1, 1};
    System.out.println("Max size with equal 0 & 1 is : " + maxLen(arr, arr.length));
  }

  private static int maxLen(int arr[], int n) {
    Map<Integer, Integer> hM = new HashMap<>();

    int sum = 0; // Initialize sum of elements
    int maxLen = 0; // Initialize result
    int endIdx = -1;

    for (int i = 0; i < n; i++) {
      arr[i] = (arr[i] == 0) ? -1 : 1;
    }

    for (int i = 0; i < n; i++) {
      sum += arr[i];

      if (sum == 0) {
        maxLen = i + 1;
        endIdx = i;
      }

      // If this sum is seen before, then update maxLen
      // if required

      if (hM.containsKey(sum + n) && (maxLen < i - hM.get(sum + n))) {
        maxLen = i - hM.get(sum + n);
        endIdx = i;
      } else {
        hM.put(sum + n, i);
      }
    }

    for (int i = 0; i < n; i++) {
      arr[i] = (arr[i] == -1) ? 0 : 1;
    }

    int end = endIdx - maxLen + 1;
    System.out.println("Start idx : " + end + " end idx : " + endIdx);

    return maxLen;
  }
}
