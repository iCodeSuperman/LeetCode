package com.medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class M322_CoinChange {

    public int coinChange(int[] coins, int amount){
        if(amount < 0) return -1;
        if(amount == 0) return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for (int coin : coins) {
                if(i - coin < 0)continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        if(dp[amount] == amount + 1){
            return -1;
        }
        return dp[amount];
    }

    /**
     * 方法二：哈希数组保存值
     * base case： 目标金额amount=0，return 0；
     * 状态变量：amount -> 0；
     * 选择状态：选择给定的硬币面值
     * dp定义：输入一个给定的目标金额amount，返回凑出amount最少的硬币数量。
     * 注意点：1.找最小的res，所以初值设为最大值或者amount。
     *       2.for循环，遍历所有给定面值的可能，找出其中最小的返回。
     *       3.用一个数组保存，其中在for前判断是否计算过，返回前判断res是不是可取值
     */

    Map<Integer, Integer> map = new HashMap<>();
    public int coinChange2(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return -1;
        }
        if(map.containsKey(amount)){
            return map.get(amount);
        }
        int res = amount + 1;
        for (int coin : coins) {
            int subProblem = coinChange2(coins, amount - coin);
            if(subProblem < 0){
                continue;
            }
            res = Math.min(res, 1 + subProblem);
        }
        int value = res == amount + 1 ? -1 : res;
        if(!map.containsKey(amount)){
            map.put(amount, value);
        }
        return value;
    }



    /**
     * 方法三：暴力法
     * base case： 目标金额amount=0，return 0；
     * 状态变量：amount -> 0；
     * 选择状态：选择给定的硬币面值
     * dp定义：输入一个给定的目标金额amount，返回凑出amount最少的硬币数量。
     * 注意点：1.找最小的res，所以初值设为最大值或者amount。
     *       2.for循环，遍历所有给定面值的可能，找出其中最小的返回。
     */
    public int coinChange3(int[] coins, int amount) {
        //base case:
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return -1;
        }
        int res = amount;
        for (int coin : coins) {
            int subProblem = coinChange3(coins, amount - coin);
            if(subProblem < 0){
                continue;
            }
            res = Math.min(res, 1 + subProblem);
        }
        return res;
    }




    @Test
    public void t(){
        int[] arr = {1, 5};
        int[] arr2 = {2};
        int amount = 11;
        System.out.println(this.coinChange(arr, amount));
    }
}
