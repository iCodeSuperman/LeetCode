package com.easy;

public class E122_BestTimeToBuyAndSellStock2 {
    /**
     * 一套框架解股票
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0){
            return 0;
        }
        /**
         * dp[2][1][0]：表示第2天，至今仍可以交易1次，未持有股票
         *              代表第二天的利润
         * n：天数
         * k：交易次数
         * 2：持有状态
         */
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }


    public int maxProfit1(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
    
    public int maxProfit2(int[] prices) {
        if(prices.length == 0) return 0;
        int profit = 0;
        int pre = prices[0];
        int min = pre;
        int len = prices.length;
        for(int i = 1; i < len; i++){
           if(pre > prices[i]) {
               //昨日价格大于今日价格，则在昨日就抛售
               profit += (pre - min);
               min = prices[i];
           }
           if(min > prices[i]){
               min = prices[i]; //今日价格为现阶段最低，则买入
           }
           pre = prices[i];
        }
        if(prices[len - 1] - min > 0){
            profit += (prices[len - 1] - min);
        }
        return profit;
    }

}
