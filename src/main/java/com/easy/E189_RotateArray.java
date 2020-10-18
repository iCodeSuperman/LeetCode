package com.easy;

public class E189_RotateArray {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        myReverse(nums, 0, nums.length);
        myReverse(nums, 0, k - 1);
        myReverse(nums, k, nums.length);
    }
    public void myReverse(int[] nums, int begin, int end){
        int i = begin;
        int j = end;
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
