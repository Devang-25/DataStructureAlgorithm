package arithmetic;

/**
 * Created by : Rakesh Gupta on 8/29/17
 * Package : arithmetic
 */
public class LargestPalindromeNumberOf3Digit {
    public static void main(String[] args) {
        long max = 0L;
        for (int i = 10000; i <= 99999; i++) {
            for (int j = 10000; j <= 99099; j++) {
                long temp =  i*j;
                if (isPalindrome(temp) && temp > max)
                    max = temp;
            }
        }

        System.out.println("Largest Palindrome of 3 digit number is : " + max);
    }

    private static boolean isPalindrome(long temp) {
        long reverse = 0, origin = temp;
        while (temp > 0){
            reverse = reverse*10+temp%10;
            temp /= 10;
        }
        return reverse==origin;
    }
}
