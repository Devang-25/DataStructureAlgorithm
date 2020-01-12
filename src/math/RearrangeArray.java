package math;

import java.util.Arrays;
import java.util.List;

public class RearrangeArray {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 2, 4, 5);
        rearrange(list);
        System.out.println(list);
    }
    public static void rearrange(List<Integer> a) {
        int n = a.size();

        for (int i = 0; i < n; i++) {
            a.set(i, a.get(i) + (a.get(a.get(i)) % n) * n);
        }

        for (int i = 0; i < n; i++) {
            a.set(i, (a.get(i) / n));
        }
    }
}
