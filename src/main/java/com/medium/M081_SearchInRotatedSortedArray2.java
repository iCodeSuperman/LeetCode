package com.medium;

public class M081_SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return false;
        }

        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return true;
            }
            // 分不清到底是前面有序还是后面有序，此时 left++ 即可。相当于去掉一个重复的干扰项
            if(nums[mid] == nums[0]){
                left ++;
                continue;
            }

            // 有序数组旋转，有一部分一定是有序的。
            if(nums[0] < nums[mid]){
                // 通过判断中间值与头值，确定左区间为有序
                if(nums[0] <= target && target < nums[mid] ){
                    // 目标在左区间，定位到左区间
                    right = mid - 1;
                }else{
                    // 目标不在左区间，开始搜索右区间
                    left = mid + 1;
                }
            }else{
                if(nums[mid] < target && target <= nums[len - 1]){
                    // 目标在右区间，定位到右区间
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }

        }

        return false;
    }
}
