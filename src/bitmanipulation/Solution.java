package bitmanipulation;

import java.util.Scanner;

/**
 * Created by : Rakesh Gupta on 9/9/17
 * Package : bitmanipulation
 {1, 1, 0, 0, 0},
 {0, 1, 0, 0, 1},
 {1, 0, 0, 1, 1},
 {0, 1, 0, 0, 0},
 {1, 0, 1, 0, 1}};
 */
public class Solution {
    static int count = 0;
    public static void visit(int[][] ar, boolean[][] v,int i, int j){
        int size = ar.length;
        if(ar[i][j] == 1){
            count++;
            v[i][j] = true;
//            if(j>0 && i<size-1){
//                visit(ar,v,i+1,j-1); // SouthWest
//            }
            if (i > 0 && j < size-1 && i < size) {
                visit(ar, v, i - 1, j);
            }

            if (j > 0 && i < size-1 && j < size) {
                visit(ar, v, i , j-1);
            }

            if(i<size-1 && j < size){
                visit(ar,v,i+1,j); // South
//                if(j < size-1)
//                    visit(ar,v,i+1,j+1); // SouthEast
            }
            if(j<size-1 && i < size )
                visit(ar,v,i,j+1); // East
        }
    }

    public static void main(String[] args) {
        int[][] ar;
        int n = 5;
        int sum = 0;
        ar = new int[][]{
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 1, 0, 0, 0},
                {1, 0, 1, 0, 1}};

        boolean[][] v = new boolean[n][n];

//        for(int i=0; i<n ; i++) {
//            for(int j=0; j<n; j++){
//                if(ar[i][j] == 1 && !v[i][j]){
//                    visit(ar,v,i,j);
//                    sum += count;
//                    count = 0;
//                }
//            }
//        }
        visit(ar, v, 0, 0);
        System.out.println(count);
    }
}