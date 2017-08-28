package arithmetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by : Rakesh Gupta on 8/29/17
 * Package : arithmetic
 */
public class LargestPrimeFactorNum {
    public static void main(String[] args) throws IOException {
        BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(io.readLine());

        long largestPrimeNum = getLargestPrimeNumber(num);
        System.out.println("Largest Prime number of " + num + " is : " + largestPrimeNum);
    }
//600851475143
    private static long getLargestPrimeNumber(long num) {
        for (long div = 2; div < num; div++) {
            if (num % div == 0) {
                num /= div;
                div--;
            }
        }
        return num;
    }
}