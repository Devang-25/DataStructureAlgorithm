package geeksforgeeks.divideconquer;

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
