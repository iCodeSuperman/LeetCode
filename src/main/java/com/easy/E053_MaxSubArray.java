package com.easy;

import org.junit.Test;

public class E053_MaxSubArray {

    public int maxSubArray(int[] nums) {
        int currSum = nums[0], maxSum = currSum;
        /**
         * if currSum = Integer.Integer.MIN_VALUE;
         * when nums[0] < 0;
         * the Sum = nums[0] + currSum will integer overflow!!!
         **/
        for(int i = 1; i < nums.length; i++){
            currSum = Math.max(nums[i], nums[i] + currSum);
            maxSum = Math.max(currSum, maxSum);
            System.out.println(nums[i]+": "+currSum +"; "+ maxSum);
        }
        return maxSum;
    }

    public int maxSA(int[] nums){
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for(int i = 1; i < len; i++){
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++){
            System.out.print(dp[i] + " ");
            if(dp[i] > res){
                res = dp[i];
            }
        }
        System.out.println();
        return res;
    }

    @Test
    public void t(){
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(this.maxSA(arr));
    }
}
