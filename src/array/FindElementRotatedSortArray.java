package array;

public class FindElementRotatedSortArray {
    public static void main(String[] args) {
        int arr[] = {16, 19, 21, 25, 3, 5, 8, 10};
        System.out.println("Index of element 5 : " + findElementInRotatedSortArr(arr, 0, arr.length - 1, 5));
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
}
