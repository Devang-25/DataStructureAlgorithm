package graph;

import java.util.Scanner;

/**
 * Created by : Rakesh Gupta on 9/9/17
 * Package : graph
 */
public class Game {

    private static int currentDepth = 0;
     private static boolean flag = true;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int dimension = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
           matrix[i] = scanner.nextLine().toCharArray();
        }
        int sum = 0;
        boolean[][] visited;

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (matrix[i][j] == '*' ){
                     visited= new boolean[dimension][dimension];
                    sum += findMaxDepth(matrix, visited, i, j);
                    currentDepth=0;
                    flag=true;
                }
            }
        }
        System.out.println(sum);
    }

    private static int findMaxDepth(char[][] n, boolean[][] bool, int i, int j) {

        if(i >= 0 && i < n.length &&  j >=0 && j < n[0].length
                && bool[i][j] != true ) {
            if (n[i][j]  == '.' ) {
                currentDepth++;
                bool[i][j] = true;

                findMaxDepth(n, bool, i-1, j);

                findMaxDepth(n, bool, i+1, j);

                findMaxDepth(n, bool, i, j-1);

                findMaxDepth(n, bool, i, j+1);
            } else if (flag) {
                currentDepth++;
                flag = false;
                bool[i][j] = true;

                findMaxDepth(n, bool, i-1, j);

                findMaxDepth(n, bool, i+1, j);

                findMaxDepth(n, bool, i, j-1);

                findMaxDepth(n, bool, i, j+1);
            }
        }
        return currentDepth;
    }
}
