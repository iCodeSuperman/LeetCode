package second;

/**
 * 121. 买卖股票的最佳时机
 * @author icodeboy
 */
public class Q121 {
    public int maxProfit(int[] prices) {
        int dp_0 = 0, dp_1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp_0 = Math.max(dp_0, dp_1 + prices[i]);
            dp_1 = Math.max(dp_1, -prices[i]);
        }
        return dp_0;
    }
}
