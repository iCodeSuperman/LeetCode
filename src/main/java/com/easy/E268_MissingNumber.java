package com.easy;


public class E268_MissingNumber {
    public int missingNumber(int[] nums) {
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++){
            ans ^= nums[i];
        }
        for(int i = 0; i <= nums.length; i++){
            ans ^= i;
        }
        return ans;
    }
}
