package com.ToOffer;

public class Offer003 {
    public int findRepeatNumber(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len; i++){
            while(i != nums[i]){
                if(i == nums[i]) return nums[i];
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
