package array;

/**
 * Created by : Rakesh Gupta on 8/12/17
 * Package : array
 */
public class FindingBiggestRegionInMatrix {
    public static void main(String[] args) {
        int arr[][] = {{0,1,1,0,1}
                          ,{1,1,1,0,0},
                           {1,1,1,1,0},
                           {1,1,1,0,1}};

        int maxRegion = getMaxRegion(arr);
        System.out.println("Biggest Region of 1's in matrix : " + maxRegion);
    }

    private static int getMaxRegion(int[][] matrix) {

        int maxRegion = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 1){
                    int size = getRegionSize(matrix, r, c);
                    maxRegion = Math.max(maxRegion, size);
                }
            }
        }
        return maxRegion;
    }

    private static int getRegionSize(int[][] matrix, int row, int column) {

        if (row<0 || column<0 || row>=matrix.length || column>=matrix[row].length)
            return 0;
        if (matrix[row][column] == 0)
            return 0;

        matrix[row][column] = 0;
        int size = 1;

        for (int r = row-1; r <= row + 1; r++) {
            for (int c = column-1; c <= column+1; c++) {
                if (r != row || c != column)
                    size += getRegionSize(matrix, r, c);
            }
        }

        return size;
    }
}
