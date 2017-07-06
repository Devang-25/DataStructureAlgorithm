package geeksforgeeks.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by rakeshgupta on 7/7/17.
 */
public class BytelandianGoldCoins {
//    private static Map<Integer, Long> table = new HashMap<Integer, Long>();
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//
//        long ans = maxDollars(n);
//        System.out.println(ans);
//    }


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
//    private static long getMaxDoller(long n) {
//        long maxTwo = 0, maxThree=0, maxFour=0;
//        HashMap<Long, Long> arr = new HashMap<>();
//
//        arr.put(0L, 0L); arr.put(1L,1L); arr.put(2L, 2L); arr.put(3L, 3L);
//
//        if (n == 0)
//            return arr.get(0L);
//        if (n == 1)
//            return arr.get(1L);
//        else  {
//
//            if (arr.get( n/2) != null){
//                maxTwo = arr.get( n/2);
//            }else {
//                maxTwo = getMaxDoller(n/2);
//            }
//
//            if (arr.get( n/3) != null){
//                maxThree = arr.get( n/3);
//            }else {
//                maxThree = getMaxDoller(n/3);
//            }
//
//            if (arr.get( n/4) != null){
//                maxFour = arr.get( n/4);
//            }else {
//                maxFour = getMaxDoller(n/4);
//            }
//
//            long sum = maxTwo+maxThree+maxFour;
//            sum = sum>=n?sum:n;
//            arr.put( n, sum);
//            return sum;
//        }
//    }

    private static long getMaxDollers(long n) {
        long maxTwo = 0, maxThree=0, maxFour=0;

        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n ==3)
            return 3;
        else  {

                maxTwo = getMaxDollers(n/2);
                maxThree = getMaxDollers(n/3);
                maxFour = getMaxDollers(n/4);

            long sum = maxTwo+maxThree+maxFour;
            sum = sum>=n?sum:n;
            return sum;
        }
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
