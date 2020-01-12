package codechef.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Mgame {

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(r.readLine());

        while (t1-- > 0) {
            String k = r.readLine();
            String data[] = k.split(" ", 2);
            long n = Long.parseLong(data[0]);
            long p = Long.parseLong(data[1]);

            long m = 0;
            m = (n - 1) / 2;
            long num_ways = 0;
            if (n <= 2) {
                System.out.println(p * p * p);
            }else if (n == p) {
                num_ways += 1 * (p - m) * (p - m);
                System.out.println(num_ways);
            } else {
                num_ways += (p - n) * 1 * (p - m);
                num_ways += (p - n) * (p - n) * 1;
                num_ways += 1 * (p - m) * (p - m);
                System.out.println(num_ways);
            }
        }
    }
}
