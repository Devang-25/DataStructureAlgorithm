package math;

import java.util.List;

public class Array3Pointer {

    public static void main(String[] args) {

    }

    public int minimize(final List<Integer> list1, final List<Integer> list2, final List<Integer> list3) {
        int i = 0, j = 0, k = 0;
        int res = Integer.MAX_VALUE;

        while (i < list1.size() && j < list2.size() && k < list3.size()) {
            int minVal = Math.min(list1.get(i), Math.min(list2.get(j), list3.get(k)));
            int maxVal = Math.max(list1.get(i), Math.max(list2.get(j), list3.get(k)));

            if (res > maxVal - minVal) {
                res = maxVal - minVal;
            }

            if (minVal == list1.get(i)) {
                i++;
            } else if (minVal == list2.get(j)) {
                j++;
            } else {
                k++;
            }
        }
        return res;
    }
}
