package hackerearthchallenge.cars24;

import java.math.BigInteger;
import java.util.Scanner;

public class TestClass {

    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);
        int arrSize = inputReader.nextInt();
        int[] arr = new int[100001];

        for (int i = 0; i < arrSize; i++) {
            arr[i] = inputReader.nextInt();
        }

        int digitSize = inputReader.nextInt();


        BigInteger totalSum = new BigInteger("0");
        for (int i = 0; i <= arrSize - digitSize; i++) {
            if (0 != arr[i]) {
                totalSum = totalSum.add(combination(arrSize - 1 - i, digitSize - 1));
            }
        }

        System.out.println(totalSum.remainder(BigInteger.valueOf(720720)));
    }

    public static BigInteger combination(int arrSize, int digitSize) {

        BigInteger totalProduct = new BigInteger("1");
        BigInteger divisor = new BigInteger("1");
        for (long i = arrSize; i > arrSize - digitSize; i--) {
            totalProduct = totalProduct.multiply(BigInteger.valueOf(i));
        }
        for (long i = 1; i <= digitSize; i++) {
            divisor = divisor.multiply(BigInteger.valueOf(i));
        }
        return totalProduct.divide(divisor);
    }
}