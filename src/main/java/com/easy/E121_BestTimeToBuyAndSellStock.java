package com.easy;

public class E121_BestTimeToBuyAndSellStock{
    public int maxProfit(int[] prices) {
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
