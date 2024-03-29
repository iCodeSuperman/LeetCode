package com.hard;


import org.junit.Test;

public class H123_BestTimetoBuyandSellStock3 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0){
            return 0;
        }
        int K = 2;
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

    @Test
    public void t(){
        int[] arr = {3,3,5,0,0,3,1,4};
        System.out.println(this.maxProfit(arr));
    }
}
