package arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by : Rakesh Gupta on 9/6/17
 * Package : arithmetic
 */
public class SingleNumInThriceNumArray {
    public static void main(String[] args) {
        ArrayList<Integer> a =  new ArrayList<>();
        a.add(3);
        a.add(8);
        a.add(5);
        a.add(1);
        a.add(3);
        a.add(8);
        a.add(5);
        a.add(1);
        a.add(3);
        a.add(8);
        a.add(5);
        a.add(1);
        a.add(7);

        int singleNum = singleNumber(a);
        System.out.println(" Single num in list of thrice each number list : " + singleNum);
    }

    public static int singleNumber(final List<Integer> arr) {
        int ones = 0, twos = 0, cbm = 0;
        int size = arr.size();

        for(int i=0;i<size;i++){
            twos = twos | (ones & arr.get(i));
            ones = ones ^ arr.get(i);
            cbm  = ~(ones & twos);
            ones &= cbm;
            twos &= cbm;
        }
        return ones;
    }
}
