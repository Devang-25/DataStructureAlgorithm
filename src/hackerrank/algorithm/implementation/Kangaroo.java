package hackerrank.algorithm.implementation;

import java.util.Scanner;

/**
 * Created by rakeshgupta on 9/26/16.
 */
public class Kangaroo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        boolean b = true;
        int d1 = x1, d2 = x2, c=0;
        while(b){
            if(d1==d2){
                System.out.println("YES");
                b = false;
            }
            else{
                d1 = d1 + v1;
                d2 = d2 + v2;
            }
            c++;
            if(c==Integer.MAX_VALUE){
                System.out.println("NO");
                b = false;
            }
        }
    }
}