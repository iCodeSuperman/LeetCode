package com.easy;

public class E027_RemoveElement {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        int len = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[len] = nums[i];
                len++;
            }
        }

        return len;
    }

    public int removeElement2(int[] nums, int val){
        int begin = 0;
        int end = nums.length;
        while(begin < end){
            if(nums[begin] == val){
                nums[begin] = nums[end - 1];
                end--;
            }else{
                begin++;
            }
        }
        return begin;
    }

}
