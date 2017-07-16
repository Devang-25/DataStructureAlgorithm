package set;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by rakeshgupta on 7/16/17.
 */
public class PrintFirstDuplicate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        printDuplicates(s);
    }

    private static void printDuplicates(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()){
            if (set.contains(c)) {
                System.out.println("Found Duplicate Char : " + c);
                return;
            }
            else if (c != ' ')
                set.add(c);
        }
        System.out.println("No Duplicates");
        return;
    }
}
