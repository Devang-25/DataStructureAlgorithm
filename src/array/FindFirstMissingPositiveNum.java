package array;

import java.util.ArrayList;

/**
 * Created by : Rakesh Gupta on 9/8/17
 * Package : array
 */
public class FindFirstMissingPositiveNum {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(-1);
        arrayList.add(1);
        int[] arr = new int[arrayList.size()];

        for (int i=0; i< arrayList.size(); i++)
            arr[i] = arrayList.get(i);

        int ans = findMissing(arr);
        System.out.println(ans);
    }


    private static int findMissing(int arr[]) {

        int size = arr.length;
        int shift = segregate (arr, size);
        int arr2[] = new int[size-shift];
        int j=0;
        for(int i=shift;i<size;i++) {
            arr2[j] = arr[i];
            j++;
        }
        return findMissingPositive(arr2, j);
    }


    private static int segregate (int arr[], int size) {
        int j = 0;
        for( int i = 0; i < size; i++) {
            if (arr[i] <= 0) {
                int temp;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }

        return j;
    }

  private static int findMissingPositive(int arr[], int size) {

        for(int i = 0; i < size; i++) {
            if(Math.abs(arr[i]) - 1 < size && arr[Math.abs(arr[i]) - 1] > 0)
                arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
        }


        for(int i = 0; i < size; i++)
            if (arr[i] > 0)
                return i+1;

        return size+1;
    }
}
