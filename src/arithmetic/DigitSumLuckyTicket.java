package arithmetic;

import java.util.Scanner;

/**
 * Created by : Rakesh Gupta on 9/4/17
 * Package : arithmetic
 */
public class DigitSumLuckyTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        int n = Integer.parseInt(num);
        int copy = n, count=1;
        int preSum=0, totalSum=0;

     while (n> 0){
         totalSum += n%10;
         n /= 10;
     }

     while (copy>0){
         if (count<4){
          preSum += copy%10;
          copy /= 10;
          count++;
         }else break;
     }

     if (preSum == (totalSum-preSum))
        System.out.println("LUCKY");
     else
         System.out.println("REGULAR");
    }
}
