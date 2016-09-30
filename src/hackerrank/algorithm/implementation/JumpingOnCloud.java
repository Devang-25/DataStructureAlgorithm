package hackerrank.algorithm.implementation;

import java.util.Scanner;

/**
 * Created by rakeshgupta on 9/26/16.
 */
public class JumpingOnCloud {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int i=0; i < n; i++){
            c[i] = in.nextInt();
        }

        int count = 0;
        for (int i = 0; i <n-1;) {
            if (c[i+2]==1) {
                i = i + 1;
                count++;
            }
            else{
                i=i+2;
                count++;
            }
        }

        System.out.println(count);

    }
}
