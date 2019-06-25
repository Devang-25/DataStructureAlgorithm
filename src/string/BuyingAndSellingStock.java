package string;

/**
 * Created by : Rakesh Gupta on 8/12/17
 * Package : string
 */
public class BuyingAndSellingStock {
    public static void main(String[] args) {
        int[] stockPrice = new int[]{7,1,5,3,6,4};
        int maxProfit = getMaxProfitFromStock(stockPrice);
        System.out.println("Maximum stock price from buying and selling : " + maxProfit);
    }

     public static int getMaxProfitFromStock(int[] stockPrice) {

        int profit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < stockPrice.length; i++) {
            profit = Math.max(profit, stockPrice[i]-minPrice);
            minPrice = Math.min(minPrice, stockPrice[i]);
        }
        return profit;
    }
}
