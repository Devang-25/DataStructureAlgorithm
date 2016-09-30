package hackerrank.algorithm.implementation;

import java.util.Scanner;

/**
 * Created by rakeshgupta on 9/26/16.
 */
public class RepeatedString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuffer s = new StringBuffer(in.nextLine());
        String sm = s.toString();
        long n = in.nextLong();

        if(sm.equals("a")){
            System.out.println(n);
            System.exit(0);
        }

        while (s.length() < n){
            s.append(sm);
        }
        s.append(sm);
        String ss = s.substring(0,(int)n);
        int cf = ss.length();
        ss = ss.replaceAll("a","");
        int cl = ss.length();

        System.out.println(cf-cl);

    }
}