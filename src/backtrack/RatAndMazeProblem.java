package backtrack;

import java.util.Arrays;

/**
 * Created by : Rakesh Gupta on 8/29/17
 * Package : backtrack
 */
public class RatAndMazeProblem {
    public static void main(String[] args) {
        int[][] maze = new int[][]{
                {1,0,0,0},
                {1,1,1,1},
                {0,1,0,0},
                {1,1,1,1}
        };

        int[][] solution = new int[4][4];

        boolean check = hasRatPath(maze, 0, 0, solution);
        System.out.println("Given path matrix has solution : " + check);
        if (check)
            System.out.println(Arrays.deepToString(solution));
    }

    private static boolean hasRatPath(int[][] maze, int x, int y, int[][] solution) {
        int size = maze.length;
        if (x == size-1 && y == size-1){
            solution[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x, y)){
            solution[x][y] = 1;
            if (hasRatPath(maze, x+1, y, solution))
                return true;

            if (hasRatPath(maze, x, y+1, solution))
                return true;

            solution[x][y] = 0;
            return false;
        }
        return false;
    }

    public static boolean isSafe(int maze[][], int x, int y) {
        int N = maze.length;
        return (x >= 0 && x < N && y >= 0 &&
                y < N && maze[x][y] == 1);
    }
}