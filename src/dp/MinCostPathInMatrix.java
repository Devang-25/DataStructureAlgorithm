package dp;

/**
 * Created by : Rakesh Gupta on 8/8/17
 * Package : dp
 */
public class MinCostPathInMatrix {
    public static void main(String[] args) {
        int cost[][] = {{1,2,3},{4,8,2},{1,5,3},{6,2,9}};

        int minCostPath = getMinCostPath(cost, 3, 2);
        System.out.println("Minimum cost path to reach in matrix : " + minCostPath);
    }

    //Using Dynamic Programming
    private static int getMinCostPath(int[][] cost, int m, int n) {
        int costArr[][] = new int[m+1][n+1];
        int sum = 0;

        for (int i = 0; i <= n; i++) {
            costArr[0][i] = sum + cost[0][i];
            sum = costArr[0][i];
        }
        sum =0;
        for (int i = 0; i <= m ; i++) {
            costArr[i][0] = sum + costArr[i][0];
            sum = costArr[i][0];
        }

        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <=n; j++) {
                costArr[i][j] = cost[i][j] + getMin(cost[i-1][j-1], cost[i-1][j], cost[i][j-1]);
            }
        }
        
        return costArr[m][n];
    }


    //Using Recursive Algorithm
    public int minCostRec(int cost[][], int m, int n){
        return minCostRec(cost, m, n, 0 , 0);
    }

    public int minCostRec(int cost[][], int m, int n, int x, int y){
        if(x > m || y > n){
            return Integer.MAX_VALUE;
        }
        if(x == m && y == n){
            return cost[m][n];
        }

        int t1 = minCostRec(cost, m , n, x+1, y);
        int t2 = minCostRec(cost, m , n, x+1, y+1);
        int t3 = minCostRec(cost, m , n, x, y+1);

        return cost[x][y] + getMin(t1,t2,t3);
    }


    public static int getMin(int a, int b, int c) {
        return Math.min(a, Math.min(b,c));
    }
}
