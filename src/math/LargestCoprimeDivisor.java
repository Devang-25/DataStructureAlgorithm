package math;

/**
 * https://www.interviewbit.com/problems/largest-coprime-divisor/
 */

public class LargestCoprimeDivisor {
    public static void main(String[] args) {
        System.out.println(new LargestCoprimeDivisor().cpFact(30,12));
        System.out.println(new LargestCoprimeDivisor().gcd(30,12));
    }

    private int cpFact(int x, int y) {
        while (gcd(x, y) != 1) {
            x = x / gcd(x, y);
        }
        return x;
    }

    private int gcd(int a, int b) {
        while (b > 0) {
            a %= b;
            if (a == 0) return b;
            b %= a;
        }
        return a;
    }
}
