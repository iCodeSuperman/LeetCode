package com.easy;

public class E053_MaxSubArray {

    public int maxSubArray(int[] nums) {
        int currSum = nums[0], maxSum = currSum;
        int v = Integer.MIN_VALUE;
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

}
