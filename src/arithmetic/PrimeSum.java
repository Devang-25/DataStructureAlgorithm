package arithmetic;

import java.util.ArrayList;

public class PrimeSum {
    public static void main(String[] args) {
        int n = 3;
        int[] ans = getNum(n);
        System.out.println(ans[0] + " " + ans[1]);
    }

    private static int[] getNum(int n) {
        int fPrime = 1, sPrime = 1;

        for (int i = 2; i <= n; i++) {
            boolean fP = isPrime(i);
            if (fP){
                boolean sP = isPrime(n-i);
                if (sP){
                    fPrime = i;
                    sPrime = n-i;
                    break;
                }
            }
        }

        return new int[]{fPrime, sPrime};
    }

    private static boolean isPrime(int n) {

            if (n > 2 && n%2 == 0)
                return false;

            int top = ((int) Math.sqrt(n))+1;
            for (int j = 3; j < top; j+=2) {
                if (n % j == 0)
                    return false;
            }

        return true;
    }


}
