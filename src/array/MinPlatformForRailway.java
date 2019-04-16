package array;

import java.util.Arrays;

public class MinPlatformForRailway {
    public static void main(String[] args) {
        int arr[] = {100, 140, 150, 200, 215, 400};
        int dep[] = {110, 300, 210, 230, 315, 600};
        int ans = findMinPlatform(arr, dep, 6);
        System.out.println("Minimum platforms needed:" + ans);
    }

    private static int findMinPlatform(int[] arr, int[] dep, int n) {
        int platformNeeded = 0, maxPlatform = 0;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0, j = 0;

        while (i < n && j < n) {

            if (arr[i] < dep[j]) {
                platformNeeded++;
                i++;
                if (platformNeeded > maxPlatform) {
                    maxPlatform = platformNeeded;
                }
            } else {
                platformNeeded--;
                j++;
            }
        }
        return maxPlatform;
    }

}
