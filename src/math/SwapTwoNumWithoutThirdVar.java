package math;

import helperutil.InputReader;

public class SwapTwoNumWithoutThirdVar {

    private static int x = 0;
    private  static int y = 0;

    public static void main(String[] args) {

        InputReader inputReader = new InputReader();
         x =  inputReader.nextInt();
         y =  inputReader.nextInt();

        System.out.println("Before swap :: x = "+ x + ", y = " + y);
        swapNum3(x, y);
        System.out.println("Before swap :: x = "+ x + ", y = " + y);
    }

    private static void swapNum1(int x1, int y1) {
        System.out.println("Swaping num using + operator.");
        x = x1+y1;
        y = x-y1;
        x = x-y;
    }

    private static void swapNum2(int x1, int y1) {
        System.out.println("Swaping num using * operator.");
        x = x1*y1;
        y = x/y1;
        x = x/y;
    }

    private static void swapNum3(int x1, int y1) {
        System.out.println("Swaping num using XOR(^) operator.");
        x = x1^y1;
        y = x^y1;
        x = x^y;
    }

}
