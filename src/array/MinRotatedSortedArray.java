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

    public int findMinElement(int[] num, int left, int right) {
        if (left == right)
            return num[left];

        if ((right - left) == 1)
            return Math.min(num[left], num[right]);

        int middle = left + (right - left) / 2;

        // not rotated
        if (num[left] < num[right]) {
            return num[left];

            // go right side
        } else if (num[middle] > num[left]) {
            return findMinElement(num, middle, right);

            // go left side
        } else {
            return findMinElement(num, left, middle);
        }
    }

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] <= nums[right])
                return nums[left];

            int m = (left + right) / 2;
            if (nums[m] >= nums[left]) {
                left = m + 1;
            } else {
                right = m;
            }
        }
        return -1;
    }
}
