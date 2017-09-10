package graph;

/**
 * Created by : Rakesh Gupta on 9/9/17
 * Package : graph
 */
public class ConnectedGroup {
    static int currentDepth = 0;
    static boolean flag = true;
    public static void main(String[] args) {
        int[][] arr  = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 1},
                {1, 0, 0, 1}};

        int sum = 0;
        int dimension = arr.length;

         for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (arr[i][j] == 1){
                    boolean[][] visited = new boolean[4][4];
                    int size = findMaxDepth(arr, visited, i, j);
                    sum += size;
                    currentDepth=0;
                    flag=true;
                }
            }
        }

        System.out.println(sum);

    }

    static int findMaxDepth(int[][] n, boolean[][] bool, int i, int j) {
        // Check if i, j (indexes) are within the size of array
        // Check if the cell is already traversed or not using bool array
        // Check if the cell value is 1 before counting it as part of a sector
        if(i >= 0 && i < n.length &&  j >=0 && j < n[0].length
                && bool[i][j] != true ) {
            if (n[i][j]  == 0) {
                currentDepth++;
                // Mark the status of the cell for backtracking purpose
                bool[i][j] = true;

                // left traversal
                findMaxDepth(n, bool, i-1, j);
                // right traversal
                findMaxDepth(n, bool, i+1, j);

                // top traversal
                findMaxDepth(n, bool, i, j-1);
                // bottom traversal
                findMaxDepth(n, bool, i, j+1);
            }
            else if (flag) {
                currentDepth++;
                flag = false;
                // Mark the status of the cell for backtracking purpose
                bool[i][j] = true;

                // left traversal
                findMaxDepth(n, bool, i-1, j);
                // right traversal
                findMaxDepth(n, bool, i+1, j);

                // top traversal
                findMaxDepth(n, bool, i, j-1);
                // bottom traversal
                findMaxDepth(n, bool, i, j+1);
            }
        }
        return currentDepth;
    }
}
