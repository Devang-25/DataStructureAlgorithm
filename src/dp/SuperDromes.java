package dp;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by rakeshgupta on 7/30/17.
 */

public class SuperDromes {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int q=sc.nextInt();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0,0);
        hashMap.put(1,1);
        while(q-->0) {

            int n = sc.nextInt();
            int count = 0;
            for (int i = 2; i <= n; i++) {
                if (!hashMap.containsKey(i)) {
                    boolean chk = chkPalindrome(i) && calBinaryNp(n);
                    if (chk) {
                            hashMap.put(i, hashMap.get(i-1)+1);
                            count++;
                    } else {
                       hashMap.put(i, hashMap.get(i-1));
                    }
                }else {
                    count += hashMap.get(i).intValue();
                }
            }

            System.out.println(count+1);
            hashMap.put(n,count+1);
        }
    }

    private static boolean calBinaryNp(int n) {
        int f=0;
        String s=Integer.toBinaryString(n);
        for(int i=0;i<s.length()/2;++i){
            if(s.charAt(i)!=s.charAt(s.length()-1)){
                f=1;
                break;
            }
        }
        if(f==0){
            return true;
        }
        return false;
    }

    public static boolean chkPalindrome(int n){
        int m=n,d,r=0;
        while(n>0){
            d=n%10;
            r=r*10+d;
            n/=10;
        }
        if(n==m)
            return true;
        return false;
    }
}