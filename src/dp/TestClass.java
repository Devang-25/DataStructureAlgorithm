package dp;
import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        for (int i = 0; i < t; i++) {

            long n = input.nextLong();
            int k = input.nextInt();
            long out_ = solve(k, n);
            System.out.println(out_);
        }
    }

    static long solve(int k, long n){

        long longBit = getBitLenth(n,k);
        long halfAns = getTotalBit2(longBit-1, k);

        StringBuilder nn = new StringBuilder("1");
        for (int i = 0; i < longBit-1; i++) {
            nn.append(""+0);
        }
        int baseNum = integerfrmbinary(nn.toString(), k);

        int remainAns = (int) ((n-baseNum+1)*longBit);

        return (halfAns+remainAns);
    }

    static int integerfrmbinary(String str, long k){
        double j=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)== '1'){
                j=j+ Math.pow(k,str.length()-1-i);
            }

        }
        return (int) j;
    }
    static long getBitLenth(long n, int k) {
        long count = 0;
        while (n > 0){
            n = (n/k);
            count++;
        }
        return count;
    }

    static long getTotalBit2(long num, int k) {

        if (num == 1)
            return k;

        long temp = k , total = 0;

        for (int i = 2; i <= num; i++) {
            total = (2*k*temp) - temp;
            temp = total;
        }
        return total;
    }

}