package bitmanipulation;

import java.util.ArrayList;

/******************************************************************************
 * Copyright (c) ::                                                           *
 * Creation Date - 5:7:2018,                                                  *
 * Created by - Rakesh Gupta,                                                 *
 * Package - bitmanipulation.DifferentBitSumPairwise                          *
 * Last modified - 7/5/18 12:14 PM                                            *
 * Project Name - DataStructureAlgorithm                                      *
 ******************************************************************************/

public class DifferentBitSumPairwise {
    public static void main(String[] args) {
        int arr[] = {81, 13, 2, 7, 96};
        int size = arr.length;
        int sum = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sum += getDifference(arr[i], arr[j]);

            }
        }
        System.out.println(sum%(1000000007));
        System.out.println(sumBitDifferences(arr, arr.length));

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(81);
        arrayList.add(13);
        arrayList.add(2);
        arrayList.add(7);
        arrayList.add(96);

        System.out.println(cntBits(arrayList));
    }

    public static int cntBits(ArrayList<Integer> arr) {

        int ans = 0;
        int n = arr.size();

        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                int a = ((arr.get(j).intValue()) & (1 << i));
                if (a != 0)
                    count++;
            }

            ans += (count * (n - count) * 2);
        }

        return ans;

    }


    public static int sumBitDifferences(int arr[], int n) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                int a = ((arr[j]) & (1 << i));
                if (a != 0)
                    count++;
            }

            ans += (count * (n - count) * 2);
        }

        return ans;
    }

    private static int getDifference(int a, int b) {
        String aS = Integer.toBinaryString(a);
        String bS = Integer.toBinaryString(b);
        int count = 0;

        int aLen = aS.length();
        int bLen = bS.length();
        if (aLen > bLen)
            bS = equal(aS, bS).toString();
        else
            aS = equal(bS, aS).toString();

        for (int i = 0; i < aS.length(); i++) {
            if (aS.charAt(i) != bS.charAt(i))
                count++;
        }
        return count;
    }

    private static StringBuffer equal(String lLen, String sLen) {
        StringBuffer ss = new StringBuffer(sLen).reverse();

        for (int i = sLen.length(); i < lLen.length(); i++) {
            ss.append(0);
        }
        return ss.reverse();
    }
}
