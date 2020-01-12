package array;

/**
 * https://www.geeksforgeeks.org/sum-fibonacci-numbers/
 */
public class SumFibonacciNumbers {
    static int arr[] = new int[Short.MAX_VALUE];

    public static void main(String[] args) {
        System.out.println(calculateSum(4));
    }

    static int calculateSum(int n) {
        return fibonacci(n + 2) - 1;
    }

    static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2)
            return (arr[n] = 1);

        if (arr[n] == 1) return arr[n];

        int k;
        if ((n & 1) == 1) {
            k = (n + 1) / 2;
        } else {
            k = n / 2;
        }
        if ((n & 1) == 1) {
            arr[n] = fibonacci(k) * fibonacci(k) + fibonacci(k - 1) * fibonacci(k - 1);
        } else {
            arr[n] = (2 * fibonacci(k - 1) + fibonacci(k)) * fibonacci(k);
        }
        return arr[n];
    }
}
