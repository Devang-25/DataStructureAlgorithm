package arithmetic;

/**
 * Created by rakeshgupta on 7/27/17.
 */
public class ZeroInFactorialNumber {
    public static void main(String[] args) {
        int n = 100;
        int totalTrailingZeros = getTotalTrailingZero(n);
        System.out.println(totalTrailingZeros);
    }

    private static int getTotalTrailingZero(int n) {

        int count = 0;

        for (int i = 5 ; n/i >= 1; i *=5) {
            count += n/i;
        }
        return count;
    }
}
