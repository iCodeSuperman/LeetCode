package com.medium;

import org.junit.Test;

public class M034_FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] position = new int[2];
        position[0] = left_bound(nums, target);
        position[1] = right_bound(nums, target);
        return position;
    }
    public int left_bound(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) /  2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                right = mid - 1;
            }
        }
        if(left >= nums.length || nums[left] != target){
            return -1;
        }
        return left;
    }

    public int right_bound(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) /  2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        if(right < 0 || nums[right] != target){
            return -1;
        }
        return right;
    }

    @Test
    public void t(){
        int[] n = {0, 1, 2, 4, 5, 6};
        int[] pos = searchRange(n, 4);
        System.out.println(pos[0]);
        System.out.println(pos[1]);
    }
}
