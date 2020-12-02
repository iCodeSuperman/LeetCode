package com.medium;

import org.junit.Test;

public class M673_NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        if(nums == null){
            return 0;
        }
        int numsLen = nums.length;
        int[] dp = new int[numsLen]; //表示以nums[i]结尾的LIS长度
        int[] count = new int[numsLen]; //表示以nums[i]结尾的LIS的组合数个数
        for(int i = 0; i < numsLen; i++){
            dp[i] = 1;
            count[i] = 1;
        }

        for(int i = 1; i < numsLen; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }else if(dp[j] + 1 == dp[i]){
                        count[i] += count[j];
                    }
                }
            }
        }

        int res = 0;
        int maxLen = dp[0];
        for(int i = 1; i < numsLen; i++){
            if(maxLen < dp[i]){
                maxLen = dp[i];
            }
        }
        for(int i = 0; i < numsLen; i++){
            if(dp[i] == maxLen){
                res += count[i];
            }
        }

        for(int i = 0; i < numsLen; i++){
            System.out.print(count[i] + " ");
        }
        System.out.println();
        return res;
    }

    @Test
    public void t(){
        int[] arr = {1,2,2,2,2,2,3,4};
        int[] arr2 = {1,2,4,3,5,4,7,2,8,8,9};
        int[] arr3 = {1,3,5,4,7};
        int[] arr4 = {1,1,2,3,3,3,4};
        System.out.println(this.findNumberOfLIS(arr2));
    }
}
