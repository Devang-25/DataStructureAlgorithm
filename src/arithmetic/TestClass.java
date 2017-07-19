package arithmetic;

import java.util.*;

class TestClass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int k=0; k<t; k++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            String str = scanner.next();
            HashMap<Character, Integer> integerHashMap = new HashMap<>();

            for (int i = 65; i < 91; i++) {
                char c = (char)i;
                int var = str.indexOf(c);
                if (var != -1) {
                    int arrData[] = getArray(str, c);
                    for (int l=0;l<arrData.length;l++) {
                        int max1 = maxRepeat(str, c, m);
                        int max2 = maxRepeat(new String((new StringBuffer(str)).reverse()), c, m);
                        int max = Math.max(max1, max2);
                        integerHashMap.put(c, max);
                    }
                }
            }
            for (int i = 97; i < 123; i++) {
                char c = (char)i;
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

    public static int[] getArray(String s, char cc){
        int arr[] = new int[s.length()];
        int k = 0;
        for (int i=0;i<s.length();i++){
            int j = s.indexOf(cc, i);
            if (j != -1){
                i = j;
                arr[k++] = j;
            }
        }
        return arr;
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