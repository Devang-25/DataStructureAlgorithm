package divideconquer;

import java.util.Scanner;

/**
 * Created by rakeshgupta on 6/29/17.
 */
public class PowerFunc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int n = scanner.nextInt();

        System.out.println("Power of " + n + " on "+ x +"   :  " + getPower(x, n));
    }

    private static int getPower(int x, int n) {
        if (n == 0)
            return 1;
            int temp = getPower(x, n/2);
            if (n %2 == 0)
                return temp*temp;
            else
                return x*temp*temp;
    }
}
