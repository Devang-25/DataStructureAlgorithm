package hackerrank.algorithm.implementation;

import java.util.Scanner;

/**
 * Created by rakeshgupta on 9/26/16.
 */
public class BonAppetit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int k = scanner.nextInt();

        int c[] = new int[num];
        for (int i = 0; i < num; i++) {
            c[i] = scanner.nextInt();
        }

        int charged = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < num; i++) {
            if (i != k)
                sum = sum+c[i];
        }

        if((sum/2)==charged)
            System.out.println("Bon Appetit");
        else
            System.out.println(charged-(sum/2));
    }
}
