package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindElementRotatedSortArray {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(16, 19, 21, 25, 3, 5, 8, 10));
        int arr[] = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            arr[i] = a.get(i);
        }
        //int arr[] = {16, 19, 21, 25, 3, 5, 8, 10};
        System.out.println("Index of element 5 : " + findElementInRotatedSortArr(arr, 0, arr.length - 1, 5));
        System.out.println("Index of element 5 : " + binarySearch(a, 0, a.size() - 1, 5));
    }

    private static int findElementInRotatedSortArr(int[] arr, int low, int high, int key) {
        int mid;
        while (low <= high) {
            mid = low + ((high - low) / 2);
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] <= arr[high]) {
                // Right part is sorted
                if (key > arr[mid] && key <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                // Left part is sorted
                if (arr[low] <= key && key < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static int binarySearch(List<Integer> a, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (a.get(mid) == target) {
                return mid;
            } else if (a.get(start) <= a.get(mid)) {
                if (target >= a.get(start) && a.get(mid) >= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (a.get(mid + 1) <= target && a.get(end) >= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
