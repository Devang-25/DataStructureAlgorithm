package backtrack;

/**
 * Created by : Rakesh Gupta on 8/30/17
 * Package : backtrack
 */
public class SolveSudoku {
    public static void main(String[] args) {
        int grid[][] = new int[][] {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        System.out.println("Original Sudoku is : ");
        writeMatrix(grid);

        if (solve(0,0,grid)) {
            System.out.println("After Solving Sudoku is : ");
            writeMatrix(grid);
        }
        else
            System.out.println("No solution exist");
    }

    static void writeMatrix(int[][] solution) {
        for (int i = 0; i < 9; ++i) {
            if (i % 3 == 0)
                System.out.println(" -----------------------");
            for (int j = 0; j < 9; ++j) {
                if (j % 3 == 0) System.out.print("| ");
                System.out.print(solution[i][j] == 0
                        ? "-"
                        : Integer.toString(solution[i][j]));

                System.out.print(' ');
            }
            System.out.println("|");
        }
        System.out.println(" -----------------------");
    }

    static boolean solve(int i, int j, int[][] cells) {
        if (i == 9) {
            i = 0;
            if (++j == 9)
                return true;
        }

        if(cells[i][j] != 0)
        return solve(i+1,j,cells);

        for (int val = 1; val <= 9; ++val) {
            if (legal(i,j,val,cells)) {
                cells[i][j] = val;
                if (solve(i+1,j,cells))
                    return true;
            }
        }

        cells[i][j] = 0;
        return false;
    }

    static boolean legal(int i, int j, int val, int[][] cells) {

        for (int k = 0; k < 9; ++k)
            if (val == cells[k][j])
                return false;

        for (int k = 0; k < 9; ++k)
            if (val == cells[i][k])
                return false;

        int boxRowOffset = (i / 3)*3;
        int boxColOffset = (j / 3)*3;

        for (int k = 0; k < 3; ++k)
            for (int m = 0; m < 3; ++m)
                if (val == cells[boxRowOffset+k][boxColOffset+m])
                    return false;

        return true;
    }
}
