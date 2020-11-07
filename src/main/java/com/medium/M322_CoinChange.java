package com.medium;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class M322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> map = new HashMap<>();
        return dp(coins, amount, map);
    }

    public int dp(int[] coins, int amount, Map<Integer, Integer> map){
        if(map.containsKey(amount)){
            return map.get(amount);
        }
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return -1;
        }
        int res = amount + 1;
        for(int i = 0; i < coins.length; i++){
            int subProblem = dp(coins, amount - coins[i], map);
            if(subProblem == -1){
                continue;
            }
            res = Math.min(res, 1 + subProblem);
        }
        if(res != amount + 1){
            map.put(amount, res);
        }else{
            map.put(amount, -1);
        }
        return map.get(amount);
    }

    @Test
    public void t(){
        int[] arr = {1, 2, 5};
        int[] arr2 = {2};
        int amount = 11;
        System.out.println(this.coinChange(arr2, amount));
    }
}
