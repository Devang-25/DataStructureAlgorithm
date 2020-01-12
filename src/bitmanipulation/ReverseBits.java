package bitmanipulation;

public class ReverseBits {
    public static void main(String[] args) {
        int n = Integer.MIN_VALUE;
        System.out.println(flipBits(n));
    }

    public static int flipBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) | (n & 1);
            n = (n >> 1);
        }
        return result;
    }
}
