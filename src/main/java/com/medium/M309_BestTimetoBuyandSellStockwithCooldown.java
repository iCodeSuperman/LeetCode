package com.medium;

public class M309_BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0){
            return 0;
        }
        int[][] dp = new int[n][2];
        int preDay = 0; // dp[i-2][0]
        for (int i = 0; i < n; i++) {
            if(i - 1 == -1){
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            int temp = dp[i - 1][0];
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], preDay - prices[i]);
            preDay = temp;
        }
        return dp[n-1][0];
    }
}
