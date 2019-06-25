package array;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

public class MinSwapsToSortArray {

    public static void main(String[] args) {
        int[] a = {3, 4, 1, 2};
        System.out.println(minSwaps(a));
    }

    public static int minSwaps(int[] arr) {
        int n = arr.length;

        ArrayList<Pair<Integer, Integer>> arrpos = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arrpos.add(new Pair(arr[i], i));

        arrpos.sort((o1, o2) -> {
            if (o1.getKey() > o2.getKey())
                return -1;
            else if (o1.getKey().equals(o2.getKey()))
                return 0;
            else
                return 1;
        });

        Boolean[] vis = new Boolean[n];
        Arrays.fill(vis, false);

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i] || arrpos.get(i).getValue() == i)
                continue;

            int cycle_size = 0;
            int j = i;
            while (!vis[j]) {
                vis[j] = true;

                j = arrpos.get(j).getValue();
                cycle_size++;
            }

            if (cycle_size > 0) {
                ans += (cycle_size - 1);
            }
        }

        return ans;
    }

//    public static int minSwaps(List<Integer> list) {
//        int n = list.size();
//
//        ArrayList<Pair<Integer, Integer>> arrpos = new ArrayList<>();
//        for (int i = 0; i < n; i++)
//            arrpos.add(new Pair(list.get(i), i));
//
//        arrpos.sort((o1, o2) -> {
//            if (o1.getKey() > o2.getKey())
//                return -1;
//            else if (o1.getKey().equals(o2.getKey()))
//                return 0;
//            else
//                return 1;
//        });
//
//        Boolean[] vis = new Boolean[n];
//        Arrays.fill(vis, false);
//
//        int ans = 0;
//
//        for (int i = 0; i < n; i++) {
//            if (vis[i] || arrpos.get(i).getValue() == i)
//                continue;
//
//            int cycle_size = 0;
//            int j = i;
//            while (!vis[j]) {
//                vis[j] = true;
//
//                j = arrpos.get(j).getValue();
//                cycle_size++;
//            }
//
//            if (cycle_size > 0) {
//                ans += (cycle_size - 1);
//            }
//        }
//
//        return ans;
//    }
}
