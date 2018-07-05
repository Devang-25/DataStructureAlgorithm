package arithmetic;

import java.util.Arrays;
import java.util.Scanner;


/******************************************************************************
 * Copyright (c) ::                                                           *
 * Creation Date - 5:7:2018,                                                  *
 * Created by - Rakesh Gupta,                                                 *
 * Package - arithmetic.StraightestPath                                       *
 * Last modified - 7/5/18 1:47 PM                                             *
 * Project Name - DataStructureAlgorithm                                      *
 ******************************************************************************/

public class StraightestPath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        char arr[][] = new char[N][M];

        for (int i = 0; i < N; i++) {
            String s = scanner.next();
            char temp[] = s.toCharArray();
            for (int j = 0; j < M; j++) {
                arr[i][j] = temp[j];
            }
        }

        int ans = getTurnCount(arr);
        System.out.println(ans);
    }

    private static int getTurnCount(char[][] arr) {
        int count[][] = new int[arr.length][arr[0].length];

        for (int i = 1; i < arr[0].length; i++) {
            if (arr[0][i] == '.' || arr[0][i] == 'V'){
                count[0][i] = count[0][i-1];
            }else {
                count[0][i] = Integer.MAX_VALUE-1;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] == '.' || arr[i][0] == 'V'){
                if (count[i-1][0] != Integer.MAX_VALUE-1)
                    count[i][0] = count[i-1][0];
            }else {
                count[i][0] = Integer.MAX_VALUE-1;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (arr[i][j] == '*'){
                    count[i][j] = Integer.MAX_VALUE-1;
                }else {

                    if (arr[i][j] == '.' && arr[i-1][j] !='V' ){
                        count[i][j] = Math.min(count[i][j-1], (count[i-1][j] + 1));

                    }else if (arr[i][j] == '.') {
                        count[i][j] = Math.min(count[i][j-1], count[i-1][j]);
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(count));

        return count[4][1];
    }
}
