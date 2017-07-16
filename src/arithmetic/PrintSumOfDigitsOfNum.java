package arithmetic;

/**
 * Created by rakeshgupta on 7/16/17.
 */
public class PrintSumOfDigitsOfNum {
    public static void printSumOfDigits(int number) {
        int sum = 0;
        while(number > 0) {
            sum += number%10;
            number /= 10;
        }
        System.out.println(sum);
    }

    public static void main(String args[]){
        java.util.Scanner input = new java.util.Scanner(System.in);
        int a = input.nextInt();
        printSumOfDigits(a);

    }
}