package array;

import java.util.ArrayList;

/**
 * Created by : Rakesh Gupta on 9/8/17
 * Package : array
 */
public class FindFirstMissingPositiveNum {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(-1);
        arrayList.add(1);

        int ans = getMissingNum(arrayList);
        System.out.println(ans);
    }

    private static int getMissingNum(ArrayList<Integer> a) {
        int min=a.get(0), max = a.get(0);

        for (int temp : a){
            if (temp > max )
                max = temp;

            if (temp < min && temp >= 0)
                min = temp;
        }

        if (max == a.size())
            min = 0;

        int total = ( ( max * (max +1))/2 ) - ( (min * (min+1))/2);

        int sum = 0;
        for (int d : a){
            if (d >= 0)
            sum += d;
        }

        return sum > 0 ? total-sum : 1;
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
