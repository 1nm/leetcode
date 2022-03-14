public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0) return 0;
        if (k > prices.length / 2) {
            int max = 0;
            for (int i = 1; i < prices.length; ++ i)
                max += prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] : 0;
            return max;
        }
        int[][] dp = new int[prices.length][k + 1];
        for (int j = 1; j <= k; ++ j) {
            int localMax = dp[0][j - 1] - prices[0];
            for (int i = 1; i < prices.length; ++ i) {
                dp[i][j] = Math.max(dp[i - 1][j], prices[i] + localMax);
                localMax = Math.max(localMax, dp[i][j - 1] - prices[i]);
            }
        }
        return dp[prices.length - 1][k];
    }
}
