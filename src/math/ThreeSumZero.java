package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSumZero {

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 3, 4, 5, 0, 8, 9, 7, -2, -3, 2));
        System.out.println(threeSum(list1));
    }

    public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> list) {
        Collections.sort(list);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < list.size() - 2; i++) {
            if (i > 0 && list.get(i).equals(list.get(i - 1)))
                continue;

            int target = -list.get(i);
            int j = i + 1;
            int k = list.size() - 1;

            while (j < k) {
                if (list.get(j) + list.get(k) == target) {
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(list.get(i));
                    tmp.add(list.get(j));
                    tmp.add(list.get(k));
                    ans.add(tmp);
                    j++;
                    k--;

                    while (j < k && list.get(j) == list.get(j - 1))
                        j++;
                    while (j < k && list.get(k) == list.get(k + 1))
                        k--;
                } else if (list.get(j) + list.get(k) > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return ans;
    }
}
