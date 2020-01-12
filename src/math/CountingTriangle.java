package math;

import java.util.ArrayList;
import java.util.Collections;

public class CountingTriangle {

    public static void main(String[] args) {

    }

    public int countTriangles(ArrayList<Integer> list) {
        int n = list.size();
        int result = 0;
        if (n < 3)
            return result;

        int mod = 1000000007;
        Collections.sort(list);

        for (int i = n - 1; i >= 0; i--) {
            int j = 0;
            int k = i - 1;
            while (j < k) {
                long sum = list.get(j) + list.get(k);
                if (sum > list.get(i)) {
                    result = (result + (k - j) % mod) % mod;
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }
}
