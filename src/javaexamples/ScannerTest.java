package javaexamples;

import java.util.Scanner;

/**
 * Created by rakeshgupta on 7/27/17.
 */
public class ScannerTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name : ");
        String name = input.nextLine();

        System.out.println("Hello " + name + "!!");
    }
}
