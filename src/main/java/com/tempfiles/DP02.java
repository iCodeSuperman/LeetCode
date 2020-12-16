package com.tempfiles;

import org.junit.Test;

public class DP02 {
   @Test
   public void coinChange(){
      int[] coins = {1, 2, 5};
      int amount = 11;
      int ans = coinChange(coins, amount);
      System.out.println(ans);
   }

   public int coinChange(int[] coins, int amount){

      int len = coins.length;
      int[] dp = new int[amount + 1];
      for(int i = 1; i < amount + 1; i++){
         dp[i] = amount + 1;
      }
      for(int i = 1; i < amount + 1; i++){
         for(int j = 0; j < len; j++){
            if(i - coins[j] >= 0){
               dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
         }
      }

      return (dp[amount] == amount + 1) ? -1 : dp[amount];
   }
}
