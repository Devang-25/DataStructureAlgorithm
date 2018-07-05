package arithmetic;

import java.util.Scanner;

/******************************************************************************
 * Copyright (c) ::                                                           *
 * Creation Date - 5:7:2018,                                                  *
 * Created by - Rakesh Gupta,                                                 *
 * Package - arithmetic.ChefAndWay                                            *
 * Last modified - 7/5/18 11:58 AM                                            *
 * Project Name - DataStructureAlgorithm                                      *
 ******************************************************************************/

public class ChefAndWay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i<n ; i++){
            arr[i] = scanner.nextInt();
        }

        int mod = (n+1) % k;
        long ans = 1L;
        for (int j = mod; j <n; j=j+k ){
            ans = ans*arr[j];
        }


        System.out.println("Ans : " + ans);
    }
}
