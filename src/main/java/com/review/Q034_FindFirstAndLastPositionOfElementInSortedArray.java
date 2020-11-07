package com.review;

public class Q034_FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int left = findFirstPosition(nums, target);
        int right = findSecondPosition(nums, target);
        ans[0] = left;
        ans[1] = right;
        return ans;
    }
    public int findFirstPosition(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        if(left != nums.length && nums[left] == target){
            return left;
        }
        return -1;
    }

    public int findSecondPosition(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                left = mid + 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        if(right != -1 && nums[right] == target){
            return right;
        }
        return -1;

    }
}
