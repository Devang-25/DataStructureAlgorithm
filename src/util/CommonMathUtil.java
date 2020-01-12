package util;

public class CommonMathUtil {

    static int diff(int a, int b) {
        return abs(a - b);
    }

    static long diff(long a, long b) {
        return abs(a - b);
    }

    static boolean isSqrt(double a) {
        double sr = Math.sqrt(a);
        return ((sr - Math.floor(sr)) == 0);
    }

    static long abs(long a) {
        return Math.abs(a);
    }

    static int abs(int a) {
        return Math.abs(a);
    }

    static int min(int... arr) {
        int min = Integer.MAX_VALUE;
        for (int var : arr)
            min = Math.min(min, var);
        return min;
    }

    static long min(long... arr) {
        long min = Long.MAX_VALUE;
        for (long var : arr)
            min = Math.min(min, var);
        return min;
    }

    static long max(long... arr) {
        long max = Long.MIN_VALUE;
        for (long var : arr)
            max = Math.max(max, var);
        return max;
    }

    static int max(int... arr) {
        int max = Integer.MIN_VALUE;
        for (int var : arr)
            max = Math.max(max, var);
        return max;
    }

    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
