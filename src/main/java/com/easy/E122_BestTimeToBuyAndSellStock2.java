package com.easy;

public class E122_BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
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
