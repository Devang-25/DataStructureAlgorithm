package recursion;

import java.util.HashSet;
import java.util.Scanner;

/******************************************************************************
 * Copyright (c) ::                                                           *
 * Creation Date - 27:7:2018,                                                 *
 * Created by - Rakesh Gupta,                                                 *
 * Package - recursion.DistinctSubString                                      *
 * Last modified - 7/27/18 7:32 PM                                            *
 * Project Name - DataStructureAlgorithm                                      *
 ******************************************************************************/

public class DistinctSubString {

    public static void main(String[] args) {
        HashSet<String> data = new HashSet<>();
        Scanner in = new Scanner(System.in);
        System.out.print(": ");
        String s = in.nextLine();
        int L = s.length();
        int N = L * (L + 1) / 2;
        String[] Comb = new String[N];
        for (int i = 0, p = 0; i < L; ++i) {
            for (int j = 0; j < (L - i); ++j) {
                Comb[p++] = s.substring(j, i + j + 1);
                //System.out.print(s.substring(j, i+j+1) + " ");
                data.add(s.substring(j, i+j+1));
            }
        }
    /*
     * for(int j=0;j<N;++j) { System.out.println(Comb[j]); }
     */
        boolean[] val = new boolean[N];
        for (int i = 0; i < N; ++i)
            val[i] = true;
        int counter = N;
        int p = 0, start = 0;
        for (int i = 0, j; i < L; ++i) {
            p = L - i;
            for (j = start; j < (start + p); ++j) {
                if (val[j]) {
                    //System.out.println(Comb[j]);
                    for (int k = j + 1; k < start + p; ++k) {
                        if (Comb[j].equals(Comb[k])) {
                            counter--;
                            val[k] = false;
                            //System.out.println(Comb[j]);
                        }
                    }
                }

            }

            start = j;
        }
        System.out.println("Substrings are " + N
                + " of which unique substrings are " + counter);
        System.out.println(data);
    }
}
