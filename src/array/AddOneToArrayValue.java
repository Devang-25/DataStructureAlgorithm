package array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by rakeshgupta on 4/3/17.
 */
public class AddOneToArrayValue {
    public static void main(String[] args) {
        int arr[] = {12,9,9};
        //int newArr[] = new int[arr.length+1];
        ArrayList<Integer> newArr = new ArrayList<>();

        StringBuffer s = new StringBuffer();

        System.out.print("Before Adding : ");
        for (int g : arr)
            System.out.print(g);
        System.out.println();

        for (int a : arr){
             s.append(a);
        }
        int c = 1 + Integer.parseInt(s.toString());
        String ss = new String(c+"");

        char abc[] = ss.toCharArray();

        for (int i = 0; i < ss.length(); i++) {
            newArr.add(Character.getNumericValue(abc[i]));
        }

        System.out.print("After Adding : ");
        for (int g : newArr)
            System.out.print(g);
    }

}
