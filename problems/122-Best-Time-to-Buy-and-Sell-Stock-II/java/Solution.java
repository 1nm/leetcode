public class Solution {
    public int maxProfit(int[] prices) {
        // find all rising sub seq and return sum of differences
        if (prices.length == 0) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; ++ i) {
            int diff = prices[i] - prices[i - 1];
            profit += diff > 0 ? diff : 0;
        }
        return profit;
    }
}