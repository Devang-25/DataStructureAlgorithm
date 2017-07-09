package divideconquer;

import java.util.Scanner;

/**
 * Created by rakeshgupta on 6/29/17.
 */
public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();

        int arr1[] = new int[n1];
        int arr2[] = new int[n1];

        for (int i = 0; i <n1; i++){
            arr1[i] = scanner.nextInt();
        }

        for (int j = 0 ; j<n1; j++){
            arr2[j] = scanner.nextInt();
        }

        System.out.println("Median of two array is : " + getMedian1(arr1, arr2));
        System.out.println("Median of two array : " + getMedian2(arr1, arr2, arr1.length));

    }

    private static int getMedian2(int[] arr1, int[] arr2, int size) {
        int n = size;
        if (n <= 0)
            return -1;
        if (n == 1)
            return (arr1[0]+arr2[0])/2;
        if (n == 2)
            return ( Math.max(arr1[0], arr2[0]) + Math.min(arr1[1], arr2[1]))/2;

        int m1 = median(arr1, n);
        int m2 = median(arr2, n);

        if (m1 == m2)
            return m1;

        if (m1 < m2){
            if (n%2 == 0)
                return getMedian2(arr1, arr2, n-n/2+1);
            return getMedian2(arr1, arr2, n-n/2);
        }
        if (n%2 == 0)
            return getMedian2(arr2, arr1, n-n/2+1);
        return getMedian2(arr2, arr1, n-n/2);
    }

    private static int median(int[] arr, int n) {
        if (n%2 == 0)
            return ( arr[n/2] + arr[n/2-1])/2;
        else
            return arr[n/2];
    }

    private static int getMedian1(int[] arr1, int[] arr2) {
        int i = 0, j = 0, count=0;
        int m1=-1, m2=-1;
        int n = arr1.length;

        for (count=0; count<=n; count++){
            if (i == n){
                m1 = m2;
                m2 = arr2[0];
                break;
            }else if (j == n ) {
                m1 = m2;
                m2 = arr1[0];
                break;
            }

            if (arr2[i] < arr2[j]){
                m1 = m2;
                m2 = arr1[i];
                i++;
            }else {
                m1 = m2;
                m2 = arr2[j];
                j++;
            }
        }
        return (m1+m2)/2;
    }
}
