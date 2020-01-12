package binarysearchtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MatrixMedian {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> m = new ArrayList<>();
        m.add(Arrays.asList(1, 3, 5).stream().collect(Collectors.toCollection(ArrayList::new)));
        m.add(Arrays.asList(2, 6, 9).stream().collect(Collectors.toCollection(ArrayList::new)));
        m.add(Arrays.asList(3, 6, 9).stream().collect(Collectors.toCollection(ArrayList::new)));

        System.out.println(findMedian(m));
    }

    public static int findMedian(ArrayList<ArrayList<Integer>> matrix) {
        int row = matrix.size();
        if (row == 0) return -1;
        int lo = 0;
        int hi = Integer.MAX_VALUE;
        int ans = 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (isLessThanHalf(matrix, mid)) {
                lo = mid + 1;
            } else {
                ans = mid;
                hi = mid - 1;
            }
        }
        return ans;
    }

    private static boolean isLessThanHalf(ArrayList<ArrayList<Integer>> a, int num) {
        int N = a.size();
        int M = a.get(0).size();
        int count = 0;

        for (int i = 0; i < N; i++) {
            count += getCount(a.get(i), num);
        }
        return count < (N * M) / 2 + 1;
    }

    private static int getCount(ArrayList<Integer> a, int n) {
        int lo = 0;
        int hi = a.size() - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (a.get(mid) > n) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
    }
}
