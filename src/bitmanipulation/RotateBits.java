package bitmanipulation;

public class RotateBits {
    private static final int BITS_IN_INTEGER = 32;

    public static void main(String[] args) {
        int x = 9;
        int N = 1;
        System.out.println("Number without any shift :: " + Integer.toBinaryString(x));
        System.out.println("After shifting clockwise : " + N + " times :: " + Integer.toBinaryString(rotateClockWiseBits(x, N)));
        System.out.println("After shifting anticlockwise : " + N + " times :: " + Integer.toBinaryString(rotateAntiClockWiseBits(x, N)));
    }

    public static int rotateAntiClockWiseBits(int x, int N) {
        return (x << N | x >> (BITS_IN_INTEGER - N));
    }

    public static int rotateClockWiseBits(int x, int N) {
        return (x >> N | x << (BITS_IN_INTEGER - N));
    }
}
