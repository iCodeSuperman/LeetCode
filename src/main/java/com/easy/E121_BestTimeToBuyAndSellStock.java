package com.easy;

public class E121_BestTimeToBuyAndSellStock{

    /**
     * 一套框架解6题
     * @param prices
     * @return
     */

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0){
            return 0;
        }
        int K = 1;
        int[][][] dp = new int[n][K+1][2];
        for (int i = 0; i < n; i++) {
            for (int k = K; k >= 1; k--) {
                if(i - 1 == -1){
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }
        return dp[n-1][K][0];
    }



    public int maxProfit2(int[] prices) {
        if(prices.length == 0) return 0;
        int profit;
        int min = prices[0];
        int max = 0;
        Boolean bool = false;
        for(int i = 1; i < prices.length; i++){
            profit = prices[i] - min;
            if(min > prices[i]) min = prices[i];
            if(max < profit) max = profit;
        }
        return max;
    }
}
