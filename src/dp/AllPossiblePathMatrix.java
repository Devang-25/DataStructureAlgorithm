package dp;

/**
 * Created by : Rakesh Gupta on 8/20/17
 * Package : dp
 */
public class AllPossiblePathMatrix {
    public static void main(String[] args) {
        int row = 4, col = 3;
        int ans = getNumOfPaths(row, col);
        System.out.println("Number of all path(Recursive Algo) from top to bottom in matrix of size : " + row + " * " + col + " is : " + ans);

        int result = numberOfPaths(row, col);
        System.out.println("Number of all path(DP) from top to bottom in matrix of size : " + row + " * " + col + " is : " + result);

    }

    //Using Recursive Algorithm
    private static int getNumOfPaths(int row, int col) {
        if (row == 1 || col == 1)
            return 1;
        return getNumOfPaths(row-1, col)+getNumOfPaths(row, col-1);
    }

    //Using Dynamic Programming
    static int numberOfPaths(int m, int n) {

        int count[][] = new int[m][n];

        for (int i = 0; i < m; i++)
            count[i][0] = 1;

        for (int j = 0; j < n; j++)
            count[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++)
                count[i][j] = count[i-1][j] + count[i][j-1];
        }
        return count[m-1][n-1];
    }
}
