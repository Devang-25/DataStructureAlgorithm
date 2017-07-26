package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rakeshgupta on 7/7/17.
 */
public class BytelandianGoldCoins {
    private static Map<Integer, Long> table = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            out.println(maxDollars(n));
        }
        out.flush();
    }

    public static long maxDollars(int n) {
        if (n < 12)
            return n;
        if (table.containsKey(n))
            return table.get(n);

        long maxDollarsOfNCoins = maxDollars(n/2)+maxDollars(n/3)+maxDollars(n/4);

        table.put(n, maxDollarsOfNCoins);
        return maxDollarsOfNCoins;
    }
}
