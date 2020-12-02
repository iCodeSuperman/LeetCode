package com.medium;

import org.junit.Test;

import java.lang.annotation.Target;

public class M494_TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
       int sum = 0;
       for(int i = 0; i < nums.length; i++){
           sum += nums[i];
       }

       if(sum < target || (sum + target) % 2 == 1){
           return 0;
       }
        /**
         * sum(A) - sum(B) = target
         *          sum(A) = target + sum(B)
         *      2 * sum(A) = target + sum(B) + sum(A)
         *      2 * sum(A) = target + sum(nums)
         *          sum(A) = (target + sum(nums) / 2 = ss
         *          nums中存在多少个子集A，使得sum(A) = ss
         */
       return subsets(nums, (sum + target) / 2);
    }

    /* 计算 nums 中有几个子集的和为 sum */
    int subsets(int[] nums, int sum) {
        int len = nums.length;
        /**
         * dp数组定义： dp[i][j] = x
         * 若只在前i个物品中选择，若当前背包的容量为j，则最多有x种方法可以恰好装满
         */
        int[][] dp = new int[len + 1][sum + 1];
        for(int i = 0; i <= len; i++){
            // 背包的最大载重为0，什么都不装，也是一种装法
            dp[i][0] = 1;
        }

        for(int i = 1; i <= len; i++){
            for(int j = 0; j <= sum; j++){
                //dp[i - 1][j] 表示当前不放入第i个物品
                //dp[i - 1][j - nums[i - 1]] 表示当前放入第i个物品
                if(j >= nums[i - 1]){
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len][sum];
    }

    @Test
    public void t(){
        int[] a = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(this.findTargetSumWays(a, target));
    }
}
