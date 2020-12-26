package com.medium;

import org.junit.Test;

import java.util.Arrays;

public class M416_PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum % 2 == 1){
            return false;
        }

        int target = sum / 2;
        boolean[][] dp = new boolean[len + 1][target + 1];
        for(int i = 0; i < len + 1; i++){
            Arrays.fill(dp[i], false);
            dp[i][0] = true;
        }

        for(int i = 1; i < len + 1; i++){
            for(int j = 1; j < target + 1; j++){
                if(j - nums[i - 1] < 0){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        for(int i = 0; i < len + 1; i++){
            for(int j = 0; j < target + 1; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[len][target];
    }


    public boolean cp(int[] nums){
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum % 2 == 1){
            return false;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        Arrays.fill(dp, false);
        dp[0] = true;


        for(int i = 1; i < len + 1; i++){
            for(int j = target; j > 0; j--){
                if(j - nums[i - 1] >= 0){
                    dp[j] = dp[j] || dp[j - nums[i - 1]];
                }
            }
        }

        return dp[target];
    }


    @Test
    public void t(){
        int[] arr2 = {1, 5, 5, 11};
        int[] arr = {1, 2, 5};
        System.out.println(this.canPartition(arr));
        System.out.println(cp(arr));
    }
}
