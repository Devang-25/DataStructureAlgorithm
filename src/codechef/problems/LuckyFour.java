package codechef.problems;

import java.util.HashMap;
import java.util.Scanner;

public class LuckyFour {
    private static HashMap<Integer, Integer> storedFreq = new HashMap<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int num = s.nextInt();
            String numStr = Integer.toString(num);
            int length = numStr.length();
            int input[] = new int[length];
            for (int i = 0; i < length; i++)
                input[i] = numStr.charAt(i) - '0';

            frequencyCount(input, length);
            System.out.println(returnFrequency(4));
            storedFreq.clear();
        }
    }

    private static void frequencyCount(int a[], int n) {
        for (int i = 0; i < n; i++) {
            if (storedFreq.containsKey(a[i])) {
                storedFreq.put(a[i], storedFreq.get(a[i]) + 1);
            } else
                storedFreq.put(a[i], 1);
        }
    }

    private static int returnFrequency(int number) {
        if (storedFreq.containsKey(number)) {
            return storedFreq.get(number);
        }
        return 0;
    }
}
