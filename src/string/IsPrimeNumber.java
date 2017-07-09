package string;

import java.util.Scanner;

/**
 * Created by rakeshgupta on 2/5/17.
 */
public class IsPrimeNumber {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        for (int j=0;j<n;j++){
            if (IsPrime(j)){
                System.out.print(j + " ");
            }
        }

    }

    private static boolean IsPrime(int n) {

        if (n > 2 && n %2 == 0){
            return false;
        }
        int top = (int)Math.sqrt(n)+1;
        for (int i=3;i<top;i+=2){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }
}
