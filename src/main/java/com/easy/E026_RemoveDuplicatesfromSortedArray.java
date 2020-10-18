package com.easy;

public class E026_RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int len = 1;
        int pre = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(pre != nums[i]){
                len++;
                nums[len - 1] = nums[i];
            }
            pre = nums[i];
        }
        return len;
    }
}
