package dp;

/**
 * Created by rakeshgupta on 3/12/17.
 */
public class Knapsack01 {
    public static void main(String[] args) {
        double w[] = new double[]{ 90.72, 6.76, 19.36,81.80, 48.77, 37.97, 46.81, 43.15, 33.80 };
        int val[] = new int[]{13 , 64,  79,  45, 79, 16, 36,10,40};

        System.out.println(knapSack(56, w, val, val.length));
        System.out.println(knapSack(56, w, val, val.length));
    }

    static double knapSack(int W, double wt[], int val[], int n) {
        int i, w;
        double K[][] = new double[n+1][W+1];

        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i==0 || w==0)
                    K[i][w] = 0;
                else if (wt[i-1] <= w)
                    K[i][w] = Math.max(val[i-1] + K[i-1][(int) (w-wt[i-1])],  K[i-1][w]);
                else
                    K[i][w] = K[i-1][w];
            }
        }


        return K[n][W];
    }

    private static int knapSack(int maxWeight, int[] wtArr, int[] valArr, int n){
        if(n == 0 || maxWeight == 0)
            return 0;

        if(wtArr[n-1] > maxWeight){
            return knapSack(maxWeight, wtArr, valArr, n-1);
        } else{
            return Math.max(valArr[n-1] + knapSack(maxWeight-wtArr[n-1], wtArr, valArr, n-1),
                    knapSack(maxWeight, wtArr, valArr, n-1));
        }
    }
}
