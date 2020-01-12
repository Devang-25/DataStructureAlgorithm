package math;

import java.util.ArrayList;
import java.util.List;

public class PowerSetOfNumber {
    public static void main(String[] args) {
        int[] arr = {4, 5, 9};
        System.out.println(powerSet(arr));
    }

    public static List<String> powerSet(int[] arr) {
        List<String> ans = new ArrayList<>();
        int size = arr.length;
        int total = 1 << size;

        for (int i = 0; i < total; i++) {
            StringBuffer num = new StringBuffer();
            for (int j = 0; j < size; j++) {
                if (((i >> j) & 1) == 1)
                    num.append(arr[j]);
            }
            ans.add(num.toString());
        }
        return ans;
    }
}
