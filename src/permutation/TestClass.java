package permutation;

/**
 * Created by rakeshgupta on 7/15/17.
 */

import java.io.*;
import java.util.*;


public class TestClass {
    static double Modul0 = 10000000011d;
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i_a=0; i_a<n; i_a++)
        {
            a[i_a] = scanner.nextInt();
        }

        double out_ = solve(a);
        System.out.println( (int)(out_%Modul0) );
    }
    static double solve(int[] a){
        double count=0;
        int len = a.length;
        for(int i=0;i<len;i++){
            int temp = a[i];
            count = count+ getData(temp);
        }
        return count;
    }

    static double getData(int n){
        String str = Integer.toBinaryString(n);
        double d = getCounter(str);
        return d;
    }

    private static double getCounter(String str) {
        double ct =0 ;
        for (int i=0;i<str.length();i++){
            if (str.charAt(i) == '1')
                ct++;
        }
        return ct;
    }
}
