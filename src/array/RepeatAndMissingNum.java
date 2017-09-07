package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RepeatAndMissingNum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5, 6, 6};
        ArrayList<Integer> arrayList = new ArrayList<>();
//        ArrayList<Integer> arrayList2 = new ArrayList<>();
//        arrayList2.addAll(arrayList);
        for (int a : arr) {
            arrayList.add(a);
        }

//        int n = 5, total = 0;
//
//        for (int t : arrayList)
//            total += t;
//
//        for (int i = 0; i < n; i++) {
//            arrayList.remove(i);
//        }
//
//        int sum = 0;
//        for (int s : arrayList)
//            sum += sum;
//
//        int repeat = sum/2;
//        int missing = (n*(n+1))/2-(total-repeat);

            int ans = getNum(arrayList);

    }

    private static int getNum(ArrayList<Integer> arrayList) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int repeat = 0, missing = 0;
        int n = arrayList.size(), total = 0;

        for (int a : arrayList)
            total += a;

        for (int d : arrayList){
            if (map.containsKey(d) ){
                map.put(d, map.get(d)+1);
                repeat = d;
            }else {
                map.put(d, 1);
            }
        }

        missing = (n*(n+1))/2-(total-repeat);
        ArrayList<Integer> an = new ArrayList<>();
        an.add(repeat);
        an.add(missing);

        System.out.println(an);
        return 0;
    }

    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        ArrayList<Integer> ret = new ArrayList<>();
        int xor = 0, x = 0, y = 0;
        for(int i=0; i<A.size(); i++) {
            xor ^= A.get(i);
        }
        for(int i=1; i<=A.size(); i++) {
            xor ^= i;
        }

        int setBit = xor & ~(xor-1);
        for(int i=0; i<A.size(); i++) {
            if((A.get(i) & setBit) != 0) {
                x ^= A.get(i);
            } else {
                y ^= A.get(i);
            }
        }
        for(int i=1; i<=A.size(); i++) {
            if((i & setBit) != 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }

        for(int i=0; i<A.size(); i++) {
            if(A.get(i) == x) {
                ret.add(x);
                ret.add(y);
                return ret;
            }

            if(A.get(i) == y) {
                ret.add(y);
                ret.add(x);
                return ret;
            }
        }

        return ret;
    }


}
