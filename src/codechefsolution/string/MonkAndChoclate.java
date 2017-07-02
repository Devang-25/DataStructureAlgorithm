package codechefsolution.string;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by rakeshgupta on 7/2/17.
 */
public class MonkAndChoclate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
       int n = scanner.nextInt();
        int m = scanner.nextInt();

        HashMap<Character, Integer> integerHashMap = new HashMap<>();

        String str = scanner.next();
        StringBuffer stringBuffer = new StringBuffer(str);
        for (int i=65; i<91; i++){
                char c = (char)i;
                int var = str.indexOf(c);
                if (var != -1){
                    int max1 = maxRepeat(str, c, m);
                    int max2 = maxRepeat(new String(stringBuffer.reverse()), c, m);
                    int max = Math.max(max1, max2);
                    integerHashMap.put(c, max);
                }
        }
        for (int i=97; i<123; i++){
            char c = (char)i;
            int var = str.indexOf(c);
            if (var != -1){
                int max1 = maxRepeat(str, c, m);
                int max2 = maxRepeat(new String(stringBuffer.reverse()), c, m);
                int max = Math.max(max1, max2);
                integerHashMap.put(c, max);
            }
        }


    }

//    public static HashMap<Character, Integer> maxRepeating(String str) {
//
//        int n = str.length();
//        int count = 0;
//        char res = str.charAt(0);
//        int cur_count = 1;
//        int startAt = 0;
//        int maxCounter = 0;
//       HashMap<Character, Integer> returnMap = new HashMap();
//        int temp = count;
//
//        for (int i=0; i<n; i++) {
//
//            if (  (i < n-1 && str.charAt(i) == str.charAt(i+1))   || (i < n-1)      ) {
//                cur_count++;
//            }
//            else {
//                  if (cur_count > maxCounter) {
//                     returnMap.put(str.charAt(i), count);
//                     count = cur_count;
//                     maxCounter = cur_count;
//                     res = str.charAt(i);
//                    startAt = i;
//                }
//                if (cur_count == count){
//                      returnMap.put(str.charAt(i), count);
//                }
//                cur_count = 1;
//            }
//        }
//
//        System.out.println("Start at index : " + (startAt-1));
//        System.out.println("Letter : " + res);
//        System.out.println("Count : " + count);
//
//        return returnMap;
//    }

    public static int maxRepeat(String str, char tempChar, int k){
        int n = str.length();
        int count = 0;
        char res = str.charAt(0);
        int cur_count = 1;
        int tempK = k;

        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put(tempChar, 0);

        for (int i=0; i<n; i++) {

            if (  (i < n-1) && (str.charAt(i) == tempChar)) {
                cur_count++;

            } else if (   (cur_count > 1) && ( tempK > 0)  ){
                 cur_count++;
                 tempK = tempK-1;
            }else {

                if (  (tempK ==0 )  && (cur_count > (hashMap.get(tempChar)).intValue())   ) {
                    count = cur_count;
                    res = tempChar ;
                   //    System.out.println("Char : " + res + " Count : " + count);
                    hashMap.put(res, count);
                }
                cur_count = 1;
                tempK = k;
            }
        }

//        System.out.println("Letter : " + tempChar);
//        System.out.println("Count : " + (count+tempK-1));
//        System.out.println("TempK : " + tempK);
        return count-1;
    }
}
