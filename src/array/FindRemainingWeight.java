package array;

/******************************************************************************
 * Copyright (c) ::                                                           *
 * Creation Date - 6:7:2018,                                                  *
 * Created by - Rakesh Gupta,                                                 *
 * Package - array.FindRemainingWeight                                        *
 * Last modified - 7/6/18 12:00 PM                                            *
 * Project Name - DataStructureAlgorithm                                      *
 ******************************************************************************/

import java.util.Arrays;
import java.util.Scanner;

/**
 * Joe is a prisoner who has been sentenced to hard labor for his crimes.
 * Each day he is given a pile of large rocks to break into tiny rocks.
 * To make matters worse, they don't provide any tools to work with. Instead,
 * he has to use the rocks themselves. He always picks up the largest two stones
 * and smashes them together. If they are of equal weight, they both disintegrate
 * entirely. If one is larger, the smaller one is disintegrated and the larger one
 * is reduced by the weight of the smaller one. Eventually there is either one stone
 * left that cannot be broken or all of the stones have been smashed. Determine the
 * weight of the last stone, or return 0 if there is none.
 */

public class FindRemainingWeight {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int arr[] = new int[size];

        for (int i=0;i<size;i++){
            arr[i] = input.nextInt();
        }

        Arrays.sort(arr);
        int inc = 1;
        int diff = 0;
        for (int j=size-1;j>=0;j=j-inc){

            if (diff == 0 && j >= 1){
                int firstValue = arr[j];
                int secondValue = arr[j-1];
                diff = firstValue - secondValue;
                inc = 2;
            }else if (diff != 0){
                diff = Math.abs(Math.abs(diff) - arr[j]);
                inc = 1;
                continue;
            }
            if (j==0){
                diff = Math.abs(Math.abs(diff) - arr[j]);
            }
        }
        if (diff != 0){
            System.out.println(Math.abs(diff));
        }else {
            System.out.println(0);
        }
    }
}
