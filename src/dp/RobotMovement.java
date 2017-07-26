package dp;

import java.util.Arrays;

/**
 * Created by rakeshgupta on 7/26/17.
 */
public class RobotMovement {
    public static void main(String[] args) {
        int gridSize = 4;
        int noOfWays = getTotalMovement(gridSize);
        System.out.println(noOfWays);
    }

    private static int getTotalMovement(int gridSize) {
        int totalWay[][] = new int[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            Arrays.fill(totalWay[i], 1);
        }

        for (int i = 1; i < gridSize; i++) {
            for (int j = 1; j < gridSize; j++) {
                totalWay[i][j] = totalWay[i-1][j] + totalWay[i][j-1];
            }
        }

        return totalWay[gridSize-1][gridSize-1];
    }
}
