package javaexamples;

import java.util.Scanner;

/**
 * Created by rakeshgupta on 7/23/17.
 */
public class TestCustomException {
    public static void main(String[] args) {
        System.out.println("Inside Main Method....");
        Scanner scanner = new Scanner(System.in);
         String name = scanner.nextLine();
        if (name != "" ) {
            System.out.println("Custom exception doesn't happen.." + name);
        } else {
            try {
                throw new MyCustomException(name);
            } catch (MyCustomException e) {
                System.out.println(e.toString());
            }
        }
    }

}

class MyCustomException extends Exception{
    String msg = null;

    public MyCustomException(String msg) {
        this.msg = msg;
    }

    public String toString() {
        return "Hi.... Returning from Custom Exception "+msg;
    }
}
