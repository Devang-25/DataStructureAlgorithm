package string;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by rakeshgupta on 7/2/17.
 */
public class MonkAndChoclateAnswer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int k=0; k<t; k++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            HashMap<Character, Integer> integerHashMap = new HashMap<>();

            String str = scanner.next();

            for (int i = 65; i < 91; i++) {
                char c = (char) i;
                int var = str.indexOf(c);
                if (var != -1) {
                    int max1 = maxRepeat(str, c, m);
                    int max2 = maxRepeat(new String((new StringBuffer(str)).reverse()), c, m);
                    int max = Math.max(max1, max2);
                    integerHashMap.put(c, max);
                }
            }
            for (int i = 97; i < 123; i++) {
                char c = (char) i;
                int var = str.indexOf(c);
                if (var != -1) {
                    int max1 = maxRepeat(str, c, m);
                    int max2 = maxRepeat(new String((new StringBuffer(str)).reverse()), c, m);
                    int max = Math.max(max1, max2);
                    integerHashMap.put(c, max);
                }
            }
            System.out.println(Collections.max(integerHashMap.values()));
        }
    }

    public static int maxRepeat(String str, char tempChar, int k){
        int n = str.length();
        int count = 0;
        int cur_count = 1;
        int tempK = k;

        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put(tempChar, 0);

        for (int i=0; i<n; i++) {
            if ( str.charAt(i) ==  tempChar ) {
                cur_count++;

            } else if (   (cur_count > 1) && ( tempK > 0)  ){
                 cur_count++;
                 tempK = tempK-1;
            }else {
                if (  (tempK ==0 )  && (cur_count > hashMap.get(tempChar))  ) {
                    count = cur_count-1;
                    hashMap.put(tempChar, count);
                }
                cur_count = 1;
                tempK = k;
            }

            if ( (i ==n-1) && (cur_count > hashMap.get(tempChar) )){
                count = cur_count -1;
                hashMap.put(tempChar, count);
                cur_count = 1;
                tempK = k;
            }
        }
        return count;
    }
}
