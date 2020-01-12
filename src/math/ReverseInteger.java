package math;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverseNum(1091));
        System.out.println(reverseNum(-20555));
        System.out.println(reverseNum(Integer.MAX_VALUE));
    }

    public static int reverseNum(int num) {
        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num *= -1;
        }

        int ans = 0, preAns = 0;
        while (num > 0) {
            int lastDigit = num % 10;
            ans = ans * 10 + lastDigit;
            if ((ans - lastDigit) / 10 != preAns) return 0;
            preAns = ans;
            num /= 10;
        }
        return isNegative ? -1 * ans : ans;
    }
}
