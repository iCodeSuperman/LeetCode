package com.medium;

public class M153_FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
       int len = nums.length;
       if(len == 1){
           return nums[0];
       }
       int left = 0;
       int right = len - 1;
       while(left < right){
           int mid = left + (right - left) / 2;
           /**
            *   这里利用mid和right比较的原因是：
            *   l   m    r      l m    r
            *  [1 2 3 4 5]     [1 2 3 4]    -> 1
            *  [5 1 2 3 4]     [4 1 2 3]    -> 2
            *  [4 5 1 2 3]                  -> 3
            *  [3 4 5 1 2]     [3 4 1 2]    -> 4
            *  [2 3 4 5 1]     [2 3 4 1]    -> 5
            *
            *  序号123中，mid < right 的情况下，最小值都落在左半区
            *  序号45中，mid > right 的情况下，最小值都落在右半区
            */
           if(nums[mid] > nums[right]){
               // 注意：mid > right的值，所以mid这个下标排除了，即不可能为最小值。
               left = mid + 1;
           }else{
               // 注意：mid <= right的值，所以mid这个下标依旧存在最小值的可能性
               right = mid;
           }
       }
       return nums[left];
    }
}
