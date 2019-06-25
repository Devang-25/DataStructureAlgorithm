package math;

public class NumProblemSolution {
    public static void main(String[] args) {
        int num = 32;
        System.out.println("Checking if num : " + num + " is power of 2 :: " + checkPowerOfTwo(num));
        System.out.println("Checking if num : " + num + " is power of 2 :: " + isPowerOfTwo(num));
        System.out.println("Floor sqrt of num : " + num + "  is :: " + floorSqrt(num));
        num = 153;
        System.out.println("Checking if num : " + num + "  is ArmStrong num :: " + isArmStrong(num));
        System.out.println();
    }

    private static boolean checkPowerOfTwo(int number) {
        return ((number & (number - 1)) == 0);
    }

    private static boolean isPowerOfTwo(int number) {
        return (number & -number) == number;
    }

    private static boolean isPowerTwo(int num) {
        return (num & 1) == 0;
    }

    private static boolean isArmStrong(int number) {
        int result = 0;
        int orig = number;
        while (number != 0) {
            int remainder = number % 10;
            result = result + remainder * remainder * remainder;
            number = number / 10;
        }
        if (orig == result) {
            return true;
        }
        return false;
    }

    public static int floorSqrt(int x) {
        if (x == 0 || x == 1)
            return x;

        int start = 1, end = x, ans = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (mid * mid == x)
                return mid;

            if (mid * mid < x) {
                start = mid + 1;
                ans = mid;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
