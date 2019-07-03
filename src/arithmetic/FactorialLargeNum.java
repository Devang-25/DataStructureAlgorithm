package arithmetic;

public class FactorialLargeNum {
    public static void main(String[] args) {
        largeNumFactorial(1000);
    }

    private static void largeNumFactorial(int n) {
        int result[] = new int[99500];
        result[0] = 1;
        int resSize = 1;

        for (int i = 2; i <= n; i++) {
            resSize = multiply(i, result, resSize);
        }

        System.out.format("Factorial of number %d is :: ", n);
        for (int i = resSize - 1; i >= 0; i--) {
            System.out.print(result[i]);
        }
        System.out.println("\n" + resSize);
    }

    private static int multiply(int x, int result[], int resSize) {
        int carry = 0;

        for (int i = 0; i < resSize; i++) {
            int prod = result[i] * x + carry;
            result[i] = prod % 10;
            carry = prod / 10;
        }

        while (carry != 0) {
            result[resSize] = carry % 10;
            carry = carry / 10;
            resSize++;
        }
        return resSize;
    }
}
