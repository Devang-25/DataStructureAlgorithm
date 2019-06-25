package searchingsorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[] {5, 9, 3, 1, 4, 0, 12};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            mergeArr(arr, start, mid, end);
        }
    }

    private static void mergeArr(int[] arr, int left, int mid, int right) {
        int lenLeft = mid - left + 1;
        int lenRight = right - mid;

        /* Create temp arrays */
        int L[] = new int[lenLeft];
        int R[] = new int[lenRight];

        /*Copy data to temp arrays*/
        for (int i = 0; i < lenLeft; ++i)
            L[i] = arr[left + i];

        for (int j = 0; j < lenRight; ++j)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;

        while (i < lenLeft && j < lenRight) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < lenLeft) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < lenRight) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
