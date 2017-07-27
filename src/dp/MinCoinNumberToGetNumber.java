package dp;

import java.util.Arrays;

/**
 * Created by rakeshgupta on 7/27/17.
 */
public class MinCoinNumberToGetNumber {
    public static void main(String[] args) {
        int coins[] = {3,4,6,7,9};
        int total = 15;

        System.out.println("Total no of solution : " + noOfSolutions(total, coins));
    }

    private static int noOfSolutions(int total, int[] coins) {
        int temp[][] = new int[coins.length+1][total+1];

        for(int i=0; i <= coins.length; i++){
            temp[i][0] = 1;
        }
        for(int i=1; i <= coins.length; i++){
            for(int j=1; j <= total ; j++){
                if(coins[i-1] > j){
                    temp[i][j] = temp[i-1][j];
                }
                else{
                    temp[i][j] = temp[i][j-coins[i-1]] + temp[i-1][j];
                }
            }
        }
        return temp[coins.length][total];
    }


}
