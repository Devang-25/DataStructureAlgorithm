package array;

import java.util.ArrayList;
import java.util.List;

public class MinFibonacciCountForNumber {
    public static void main(String[] args) {
        System.out.println(fibSum(9));
    }

   static int fibSum(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);

        for (int i = 2; list.get(i - 1) < n; i++) {
            int val = list.get(i - 1) + list.get(i - 2);
            list.add(val);
        }

        int ans = 0;
        int size = list.size();
        size--;
        while (n > 0) {
            while (list.get(size) > n) {
                size--;
            }
            n -= list.get(size);
            ans++;
        }
        return ans;
    }
}
