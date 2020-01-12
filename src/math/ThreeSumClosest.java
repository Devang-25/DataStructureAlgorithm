package math;

import java.util.ArrayList;
import java.util.Collections;

public class ThreeSumClosest {

    public int threeSumClosest(ArrayList<Integer> list, int num) {
        Collections.sort(list);
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i=0; i< list.size()-2; i++) {
            int j = i+1;
            int k = list.size()-1;
            while (j<k) {
                int sum = list.get(i) + list.get(j) + list.get(k);
                int diff = Math.abs(sum - num);
                if (diff == 0) {
                    return num;
                }
                if (diff < min) {
                    min = diff;
                    res = sum;
                }
                if(sum <= num) {
                    j++;
                }
                else {
                    k--;
                }
            }
        }
        return res;
    }
}
