package org.chandu.saturn.top150;

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
 * <p>
 * Find and return the maximum profit you can achieve.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 * Example 2:
 * <p>
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Total profit is 4.
 * Example 3:
 * <p>
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 **/

public class StockBuyAndSell2 {

    public static void main(String[] args) {
        StockBuyAndSell2 sbs2 = new StockBuyAndSell2();

        int[] test1 = new int[]{7, 1, 5, 3, 6, 4};

        System.out.println("Maximum profit - " + sbs2.maxProfit(test1));
    }

    public int maxProfit(int[] prices) {
        int prof = 0, min = prices[0];

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > min) {
                prof = prof + (prices[i] - min);
            }
            min = prices[i];
        }
        return prof;
    }

}
