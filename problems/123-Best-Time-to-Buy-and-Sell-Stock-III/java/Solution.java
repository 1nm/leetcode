public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[] profit1 = new int[prices.length];
        int[] profit2 = new int[prices.length];
        int min = prices[0];
        for (int i = 1; i < prices.length; ++ i) {
            if (prices[i] < min) min = prices[i];
            profit1[i] = Math.max(profit1[i - 1], prices[i] - min);
        }
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; -- i) {
            if (prices[i] > max) max = prices[i];
            profit2[i] = Math.max(profit2[i + 1], max - prices[i]);
        }
        int result = 0;
        for (int i = 0; i < prices.length; ++ i) {
            int profit = profit1[i] + profit2[i];
            if (result < profit) result = profit;
        }
        return result;
    }
}
