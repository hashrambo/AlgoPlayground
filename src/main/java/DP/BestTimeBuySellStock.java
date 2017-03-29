package DP;

/**
 * Leetcode - 121 Best Time to Buy and Sell Stock
 *
 * You have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e. buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 *
 * Created by hashrambo on 3/29/17.
 */
public class BestTimeBuySellStock {

    /**
     * This function finds the maximum profit at a linear time.
     * Max profit is calculated by the difference between the selling price and the purchasing price.
     * Since the sequence of the array represents the sequence of days, profit can only be computed by
     * P_i - P_i-1 but not the other way round.
     * The approach is to keep track of the minimum value. For each element check against the min value,
     * update the min value if the current stock price is less than min. If not, update the max profit value
     * by taking the max of the current profit and the difference between the min and the current stock price.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param stocks
     * @return
     */
    private static int findMaxProfit (int [] stocks) {
        if (stocks.length == 0)
            return 0;

        int days = stocks.length;
        int min = stocks[0];
        int profit = 0;

        for (int i=0; i<days; i++) {
            if (stocks[i] < min) {
                min = stocks[i];
            }
            else {
                profit = Math.max(profit, stocks[i] - min);
            }
        }
        return profit;
    }

    public static void main (String[] args) {
        int [] stocks = new int [] {7, 1, 5, 3, 6, 4};

        System.out.println(findMaxProfit(stocks)); // 5

        int [] stocks2 = new int [] {7, 6, 4, 3, 1};

        System.out.println(findMaxProfit(stocks2)); // 0

        int [] empty = new int [] {};

        System.out.println(findMaxProfit(empty)); // 0

    }
}
