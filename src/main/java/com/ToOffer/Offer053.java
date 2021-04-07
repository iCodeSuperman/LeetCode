package com.ToOffer;

public class Offer053 {
    public int missingNumber1(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i){
                return i;
            }
        }
        return -1;
    }

    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] == mid){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}
