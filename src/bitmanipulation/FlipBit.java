package bitmanipulation;

import java.util.ArrayList;

public class FlipBit {
    public static void main(String[] args) {
        FlipBit flipBit = new FlipBit();
        System.out.println(flipBit.countBit("11011000011111000000111"));
    }

    public ArrayList<Integer> countBit(String s) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> zeroOneList = new ArrayList<>();

        if (s == null || !s.contains("0")) {
            return ans;
        }
        for (int i = 0; i < s.length(); i++) {
            zeroOneList.add(s.charAt(i) == '0' ? 1 : -1);
        }

        int total = 0, left = 0, right = 0, maxSum = Integer.MIN_VALUE;
        int leftAns = 0, rightAns = 0;

        for (int i = 0; i < s.length(); i++) {
            total += zeroOneList.get(i);
            if (total < 0) {
                left = i + 1;
                total = 0;
            } else if (total > maxSum) {
                leftAns = left;
                rightAns = i;
                maxSum = total;
            }
        }

        if (maxSum <= 0) {
            return ans;
        } else {
            ans.add(leftAns + 1);
            ans.add(rightAns + 1);
        }
        return ans;
    }
}
