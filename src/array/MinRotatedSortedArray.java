package array;

public class MinRotatedSortedArray {
    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50, 5, 7};
        System.out.println(
                "Min element from rotated sorted array : " + findMin(arr, 0, arr.length - 1));
    }

    private static int findMin(int arr[], int left, int right) {
        if (left > right) return -1;
        if (left == right) return arr[left];

        int mid = (left + right) / 2;

        if (mid < right && arr[mid + 1] < arr[mid]) return arr[mid + 1];

        if (mid > left && arr[mid - 1] > arr[mid]) return arr[mid];

        if (arr[right] > arr[mid]) return findMin(arr, left, mid - 1);

        return findMin(arr, mid + 1, right);
    }
}
