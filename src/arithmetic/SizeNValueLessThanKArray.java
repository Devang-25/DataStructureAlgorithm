package arithmetic;

import java.util.ArrayList;

public class SizeNValueLessThanKArray {
    static int counter = 0;

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(1);
        arr.add(5);

        StringBuffer stringBuffer = new StringBuffer();
        for (int d : arr)
            stringBuffer.append(d);

        int B = 2;
        int C = 2;
        printAllKLengthRec(stringBuffer.toString(), "", B, C);
        System.out.println(counter);
    }

    private static void printAllKLengthRec(String set, String prefix, int limit, int k) {

        if (k == 0) {
            if ((prefix.length() == 1 && prefix.charAt(0) == '0') ||
                    (prefix.charAt(0) != '0' && Integer.parseInt(prefix) < limit && Integer.parseInt(prefix) != 0) ) {
                counter++;
            }
            return;
        }

        for (int i = 0; i < set.length(); ++i) {
            String newPrefix = prefix + set.charAt(i);
            printAllKLengthRec(set, newPrefix, limit, k - 1);
        }
    }
}
