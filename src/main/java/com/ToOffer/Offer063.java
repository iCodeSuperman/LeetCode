package com.ToOffer;

/**
 * @author icodeboy
 */
public class Offer063 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] del = new int[len];

        for (int i = 0; i < len; i++) {
            for(int j = i; j < len; j++){
                int temp = prices[j] - prices[i];
                del[j] = temp > del[j] ? temp : del[j];
            }
        }

        int max = 0;
        for (int i = 0; i < len; i++) {
            max = del[i] > max ? del[i] : max;
        }
        return max;
    }

    /**
     * 状态定义 dp[i] 表示前i日的最大利润
     *      而第i日的利润 = max( dp[i-1], price[i] - 前i-1日的最低价格 )
     * 状态转移方程：
     *      dp[i] = max( dp[i-1], price[i]-min(price[0:i-1] )
     * 初始值:
     *      dp[0] = 0;
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int len = prices.length;
        int[] dp = new int[len];
        int min = prices[0];
        dp[0] = 0;
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return dp[len - 1];
    }
}
