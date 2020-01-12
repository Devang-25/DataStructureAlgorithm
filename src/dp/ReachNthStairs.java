package dp;

/**
 * No of way to reach top & fibonacci no relation
 * countWay(n)= fibonacci(n+1)
 */
public class ReachNthStairs {

    public static void main(String[] args) {
        int n = 4, m = 2;
        System.out.println(countWays(n + 1, m));
    }

    public static int countWays(int n, int m) {
        if (n <= 1) return n;

        int res = 0;
        for (int i = 1; i <= m && i <= n; i++) {
            res += countWays(n - i, m);
        }
        return res;
    }
}
