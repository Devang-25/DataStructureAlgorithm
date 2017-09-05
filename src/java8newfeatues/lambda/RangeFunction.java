package java8newfeatues.lambda;

import java.util.*;

/**
 * Created by : Rakesh Gupta on 9/4/17
 * Package : java8newfeatues.lambda
 */
public class RangeFunction {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int c = scanner.nextInt();
        int d = scanner.nextInt();

        long slope = 0;
        if (a == c || b == d)
            System.out.println("YES");
        else {
            slope = c/a;
            if (slope == (d/b))
                System.out.println("YES");
            else
                System.out.println("NO");
        }

        Deque<Integer> queue = new ArrayDeque<>(Arrays.asList(1,2,3,4));
        queue.add(5);
        queue.removeFirst();
        queue.removeFirst();


        List<String> nameList = new ArrayList<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));
        for (String s : nameList)
            System.out.println(s);
    }
}
