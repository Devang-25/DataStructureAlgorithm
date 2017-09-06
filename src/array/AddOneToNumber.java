package array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by : Rakesh Gupta on 9/7/17
 * Package : array
 */
public class AddOneToNumber {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 3, 2, 1, 1, 2, 5, 9, 6, 5};

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int  temp : arr)
            arrayList.add(temp);
    }


    public static final int[] addOne(int[] digit) {
        int carry = 1;
        ArrayList<Integer> arr = new ArrayList<>();

        int[] digits = new int[digit.length];
        for (int i = 0; i < arr.size(); i++) {
            digits[i] = arr.get(i);
        }

        int[] result = new int[digits.length];
        for (int i = digits.length - 1; i >= 0; i--) {
            int val = digits[i] + carry;
            result[i] = val % 10;
            carry = val / 10;
        }
        if (carry == 1) {
            result = new int[digits.length + 1];
            result[0] = 1;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            ans.add(result[i]);
        }
        return result;
    }

    public ArrayList<Integer> plusOne(ArrayList<Integer> arr) {
        int carry = 1;
        int[] digits = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            digits[i] = arr.get(i);
        }

        int[] result = new int[digits.length];
        for (int i = digits.length - 1; i >= 0; i--) {
            int val = digits[i] + carry;
            result[i] = val % 10;
            carry = val / 10;
        }
        if (carry == 1) {
            result = new int[digits.length + 1];
            result[0] = 1;
        }

        boolean f = true;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            if(result[i] == 0 && f){
                f = true;
                continue;
            }else{
                f = false;
            }
            ans.add(result[i]);
        }
        return ans;
    }

}
