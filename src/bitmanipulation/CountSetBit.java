package bitmanipulation;

/**
 * Created by : Rakesh Gupta on 9/6/17
 * Package : arithmetic
 */
public class CountSetBit {
    public static void main(String[] args) {
        long num = 345L;

        int numOfSetBit = numSetBits(num);

        System.out.println("Count number of Set Bit in Number : " + numOfSetBit);
        System.out.println("Count number of Set Bit in Number : " + numberOfSetBits(((int) num)));
        System.out.println("Count number of Set Bit in Number : " + Long.bitCount(num));

    }

    public  static int numSetBits(long a) {
        String s = Long.toBinaryString(a);
        int count = 0;
        for(int size=s.length(), i=0; i<size;i++){
            if(s.charAt(i) == '1')
                count++;
        }
        return count;
    }

    public static int numberOfSetBits(int i) {

        i = i - ((i >> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >> 2) & 0x33333333);
        return (((i + (i >> 4)) & 0x0F0F0F0F) * 0x01010101) >> 24;
    }

}
