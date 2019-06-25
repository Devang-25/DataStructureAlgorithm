package math;

public class SumWithoutOperator {
    public static void main(String[] args) {
        int a = 5;
        int b = 7;
        System.out.println("Sum without using arithmetic operator  " + a + " + " + b + " = " + sum(a, b));
    }

    private static int sum(int a, int b) {
        if (b == 0) return a;
        int partialSum = a ^ b;
        int carry = (a & b) << 1;
        return sum(partialSum, carry);
    }
}
