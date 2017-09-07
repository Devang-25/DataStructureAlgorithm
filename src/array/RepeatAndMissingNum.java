package array;

import java.util.ArrayList;
import java.util.Arrays;

public class RepeatAndMissingNum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,5};
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int a : arr) {
            arrayList.add(a);
        }

        int n = 5, total = 0;

        for (int t : arrayList)
            total += t;

        for (int i = 0; i < n; i++) {
            arrayList.remove(i);
        }

        int sum = 0;
        for (int s : arrayList)
            sum += sum;

        int repeat = sum/2;
        int missing = (n*(n+1))/2-(total-repeat);

    }
}
