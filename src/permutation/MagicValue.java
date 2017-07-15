package permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by rakeshgupta on 7/15/17.
 */

public class MagicValue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        String[] arr_a = br.readLine().split(" ");
        int[] a = new int[n];
        for(int i_a=0; i_a<arr_a.length; i_a++)
        {
            a[i_a] = Integer.parseInt(arr_a[i_a]);
        }

        long out_ = solve(a);
        System.out.println(out_);

        wr.close();
        br.close();
    }
    static long solve(int[] a){
        int count=0;
        int len = a.length;
        for(int i=0;i<len;i++){
            int temp = a[i];
            count = count+ getData(temp);
        }
        return count;
    }

    static int getData(int n){
        String str = Integer.toBinaryString(n);
        int d = getCounter(str);
//        int c = (str.length() - (str.replaceAll("1", "")).length());
        return d;
    }

    private static int getCounter(String str) {
        int ct =0 ;
        for (int i=0;i<str.length();i++){
            if (str.charAt(i) == '1')
                ct++;
        }
        return ct;
    }
}
