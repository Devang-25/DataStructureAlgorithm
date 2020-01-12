package math;

import java.util.ArrayList;

public class MinimizeAbsoluteDifference {

    public int solve(ArrayList<Integer> list1, ArrayList<Integer> list2, ArrayList<Integer> list3) {
        int diff = Integer.MAX_VALUE;
        int i = 0, j = 0, k = 0;
        int p = list1.size();
        int q = list2.size();
        int r = list3.size();

        while (i<p && j<q && k<r) {
            int maximum = Math.max(list1.get(i), Math.max(list2.get(j), list3.get(k)));
            int minimum = Math.min(list1.get(i), Math.min(list2.get(j), list3.get(k)));

            if (maximum - minimum < diff) {
                diff = maximum - minimum;
            }

            if (diff == 0) break;

            if (list1.get(i) == minimum) i++;
            else if (list2.get(j) == minimum) j++;
            else k++;
        }
        return diff;
    }
}
