/*
buy[i] = max(buy[i-1], cooldown[i-1] - prices[i]); // hold or buy
sell[i] = max (sell[i-1], buy[i-1] + prices[i]); // hold or sell
cooldown[i] = max(sell[i-1], buy[i-1], cooldown[i-1]); // prev could be buy sell or cooldown

cooldown[i] = sell[i-1];

buy[i] = max(buy[i-1], sell[i-2] - prices[i]); // hold or buy
sell[i] = max(sell[i-1], buy[i-1] + prices[i]); // hold or sell


 */
public class Solution {
    public int maxProfit(int[] prices) {
        // After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
        int buy = Integer.MIN_VALUE, sell = 0, preBuy = Integer.MIN_VALUE, preSell = 0;
        for (int price : prices) {
            preBuy = buy;
            buy = Math.max(buy, preSell - price);
            preSell = sell;
            sell = Math.max(preSell, preBuy + price);
        }
        return sell;
    }
}
