package dp;

/**
 * Created by rakeshgupta on 7/27/17.
 */
public class NumberOfWayToGetNumber {
    public static void main(String[] args) {
        int coins[] = {1,2,3};
        int total = 5;
        int totalNumberOfWayToGetNumber = noOfSolutions(total, coins);
        System.out.println(totalNumberOfWayToGetNumber);
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
