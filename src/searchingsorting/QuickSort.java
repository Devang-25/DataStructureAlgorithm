package searchingsorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] unsorted = {6, 5, 3, 1, 8, 7, 2, 4};
        System.out.println(Arrays.toString(unsorted));
        quickSort(unsorted, 0, unsorted.length-1);
        System.out.println(Arrays.toString(unsorted));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pIndex = partitionArr(arr, start, end);
            quickSort(arr, start, pIndex - 1);
            quickSort(arr, pIndex + 1, end);
        }
    }

    private static int partitionArr(int[] arr, int start, int end) {
        int pivot = arr[end];
        int pIndex = start;

        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, pIndex);
                pIndex++;
            }
        }
        swap(arr, pIndex, end);
        return pIndex;
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
