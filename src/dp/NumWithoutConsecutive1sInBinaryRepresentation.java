package dp;

/**
 * Created by : Rakesh Gupta on 8/14/17
 * Package : dp
 */
public class NumWithoutConsecutive1sInBinaryRepresentation {
    public static void main(String[] args) {
        int bitLength = 5;
        int num = getCount(bitLength);
        System.out.println("Number without consecutive 1's in binary representation of number is :" + num);
    }

    private static int getCount(int n) {
        int a[] = new int[n];
        int b[] = new int[n];

        a[0] = 1;
        b[0] = 1;

        for(int i=1; i < n; i++){
            a[i] = a[i-1] + b[i-1];
            b[i] = a[i-1];
        }

        return a[n-1] + b[n-1];
    }
}
