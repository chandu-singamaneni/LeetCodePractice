package org.chandu.saturn.top150;


/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 * <p>
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 **/


public class StockBuyAndSell {

    public static void main(String[] args) {
        StockBuyAndSell sbs = new StockBuyAndSell();

        int[] test1 = new int[]{4, 6, 3, 7, 2, 9};

        System.out.println("Maximum profit - " + sbs.maxProfit(test1));
    }

    public int maxProfit(int[] prices) {
        int low = 0, high = 0, diff = 0;

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < prices[low]) {
                low = i;
                high = i;
            }

            if (prices[i] > prices[high]) {
                high = i;
                int tempDiff = prices[high] - prices[low];
                if (tempDiff > diff) {
                    diff = tempDiff;
                }
            }

        }

        return diff;

    }

}
