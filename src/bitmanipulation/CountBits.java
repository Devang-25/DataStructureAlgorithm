package bitmanipulation;

/**
 * Created by rakeshgupta on 7/15/17.
 */
import java.util.*;
import java.io.*;

class CountBits {
    public static void main(String args[] ) throws Exception {
        int count=0;
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i=0;i < T;i++)
        {
            int N = s.nextInt();
            count=0;
            while(N!=0)
            {
                int x = N%2;
                N=N/2;
                if(x==1)
                    count++;
            }
            System.out.println(count);
        }
    }
}