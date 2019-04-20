package string;

import java.util.HashSet;

public class AllPossibleStringLengthKFromString {

    private static HashSet<String> hashSet = new HashSet<>();

    public static void main(String[] args) {
        String str = "abcd";
        printAllPossibleString(str, 5);
        System.out.println(hashSet.size());
        System.out.println(hashSet.toString());
    }

    private static void printAllPossibleString(String str, int len) {
        int n = str.length();
        printAllKLengthStr(str.toCharArray(), "", n, len);
    }

    private static void printAllKLengthStr(char[] charArray, String prefix, int n, int len) {
        if (len == 0) {
            hashSet.add(prefix);
            return;
        }
        for (int i = 0; i < n; ++i) {
            String newPrefix = prefix + charArray[i];
            printAllKLengthStr(charArray, newPrefix, n, len - 1);
        }
    }
}
