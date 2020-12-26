package com.medium;

import org.junit.Test;

public class M518_CoinChange2 {

    public int change2(int amount, int[] coins){
        if(coins == null || amount < 0){
            return 0;
        }
        int len = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int i = 1; i < len + 1; i++){
            for(int j = 1; j < amount + 1; j++){
                if(j - coins[i - 1] >= 0){
                    dp[j] = dp[j] + dp[j - coins[i - 1]];
                }
            }
        }
        return dp[amount];
    }


    private int count = 0;
    public int change(int amount, int[] coins) {
        back(amount, coins, coins.length);
        return count;
    }

    public void back(int value, int[] coins, int len){
        if(value == 0){
            count++;
            return;
        }
        if(value < 0){
            return;
        }
        for(int i = 0; i < len; i++){
            back(value - coins[i], coins, len);
        }
    }

    @Test
    public void t(){
        int[] arr = {1, 2, 5};
        int amount = 5;
        System.out.println(this.change2(amount, arr));
    }
}
