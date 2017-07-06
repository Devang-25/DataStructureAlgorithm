package geeksforgeeks.dp;

import java.util.Scanner;

/**
 * Created by rakeshgupta on 7/6/17.
 */
public class UglyNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int uglyNumber = getNthUglyNumber(num);
        System.out.println(uglyNumber);

        int uglyNo = getNthUglyNoDP(num);
        System.out.println(uglyNo);
    }

    private static int getNthUglyNoDP(int num) {
        int ugly[] = new int[num];
        int i2 = 0, i3 = 0, i5 = 0;
        int nextMultipleOf2 = 2, nextMultipleOf3 = 3, nextMultipleOf5 = 5;

        ugly[0] = 1;
        for (int i=1; i<num; i++){

        }
        return 0;
    }

    private static int getNthUglyNumber(int num) {
        int count = 1, i = 1;
        while ( num > count){
            i++;
            if (uglyNumber(i) == 1){
                count++;
            }
        }
        return i;
    }

    private static int uglyNumber(int no) {
        no = maxDivide(no, 2);
        no =  maxDivide(no, 3);
        no = maxDivide(no, 5);
        return no == 1 ? 1 : 0;
    }

    private static int maxDivide(int a, int b) {
        while (a % b == 0)
            a = a/b;
        return a;
    }
}
