package arithmetic;

/**
 * Created by : Rakesh Gupta on 8/30/17
 * Package : arithmetic
 */
public class NumDivisibleByTill20 {
    public static void main(String[] args) {
        long divisibleByNumber = 30;

        long ans = findMultiple(divisibleByNumber);
        System.out.println("Smallest Positive number divisible by 1 to "+ divisibleByNumber + " is : " + ans);
    }

    private static long findMultiple(long divisibleByNumber) {
        long lcm = 1;
        for (long i = 2; i < divisibleByNumber; i++) {
//            lcm = findLCM(lcm, i);
            lcm *= i/gcd(lcm,i);
        }
        return lcm;
    }

    private static long findLCM(long a, long b) {
        long lcm, hcf = 0, index = 1;
        long max = a>b?a:b;

        while (index<max){
            if (a%index == 0 && b%index == 0)
                hcf = index;
            index++;
        }

        lcm = (a*b)/hcf;
        return lcm;
    }

    static long gcd(long a, long b) {
        while(b > 0) {
            a %= b;
            if (a == 0) return b;
            b %= a;
        }
        return a;
    }
}
