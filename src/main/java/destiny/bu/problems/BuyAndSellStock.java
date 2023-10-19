package destiny.bu.problems;

public class BuyAndSellStock {

    private static int getMaxPricePossibilityIndex(int[] prices, int endPoint) {
        for (int i = endPoint - 1; i >= 0; i--) {
            if (prices[i] < prices[i + 1]) {
                return i + 1;
            }
        }
        return endPoint;
    }

    private static int getMinPricePossibilityIndex(int[] prices, int startPoint) {
        for (int i = startPoint; i < prices.length - 1; i++) {
            if (prices[i] >= prices[i + 1]) {
                return i + 1;
            }
        }
        return startPoint;
    }

    public int maxProfitTwo(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(prices[i] - minPrice, maxProfit);
            }
        }
        return maxProfit;
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int minBuyIndex = 0;
        int maxSellIndex = prices.length - 1;
        do {
            profit = Math.max(profit, prices[maxSellIndex] - prices[minBuyIndex]);
            int nextMinBuyIndex = getMinPricePossibilityIndex(prices, minBuyIndex);
            profit = Math.max(profit, prices[maxSellIndex] - prices[nextMinBuyIndex]);
            int nextMaxSellIndex = getMaxPricePossibilityIndex(prices, maxSellIndex);
            profit = Math.max(profit, prices[nextMaxSellIndex] - prices[minBuyIndex]);
            if (nextMinBuyIndex == minBuyIndex && nextMaxSellIndex == maxSellIndex) {
                break;
            }
            minBuyIndex = nextMinBuyIndex;
            maxSellIndex = nextMaxSellIndex;
        } while (minBuyIndex < getMaxPricePossibilityIndex(prices, prices.length - 1));
        return profit;
    }
}
