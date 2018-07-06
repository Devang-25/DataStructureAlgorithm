
package array;

import java.util.Arrays;
import java.util.Scanner;

public class Test {

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