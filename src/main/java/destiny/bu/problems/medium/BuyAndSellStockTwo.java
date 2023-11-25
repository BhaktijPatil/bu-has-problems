package destiny.bu.problems.medium;

/*
 prices[i] is price of stock on the ith day.
 each day -> buy and/or sell the stock
 hold at most 1 share of the stock.
 can buy and sell it on the same day.
 Find Max Profit

 Sliding Window Problem

 startPtr = 0;
 profit = 0;

 Until a number is smaller than startPtr, increase the start Ptr
 Once a number is greater than startPtr, sell the stock and startPtr at currPrice

 Time = 14:30

 Note - Even better approach -> find sums of differences of adjacent numbers when positive, removing the need for a startPtr -> sum(ifPositive(prices[i]-prices[i-1]))
 */

import java.util.Arrays;

public class BuyAndSellStockTwo {
    public int maxProfit(int[] prices) {
        int startPtr = 0;
        int profit = 0;


        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[startPtr]) {
                profit += prices[i] - prices[startPtr];
            }
            startPtr = i;
        }
        return profit;
    }
}
