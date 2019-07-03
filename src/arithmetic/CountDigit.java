package arithmetic;

public class CountDigit {
    public static void main(String[] args) {
        System.out.println(countDigit(1234567890));
        System.out.println(countDigitRecursive(1234567890));
    }

    private static int countDigit(int n) {
        return (int) (Math.log10(n) + 1);
    }

    private static int countDigitRecursive(int n) {
        if (n == 0)
            return 0;
        return 1 + countDigitRecursive(n / 10);
    }
}
