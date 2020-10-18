package com.medium;

import org.junit.Test;

public class M033_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        return bSearch(nums, 0, nums.length-1, target);
    }

    public int bSearch(int[] nums, int start, int end, int target) {
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target == nums[mid]){
                return mid;
            }

            //必定有一侧是有序的
            if(nums[start] <= nums[mid]){
                if(nums[start] <= target && target <= nums[mid]){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }else{
                if(nums[mid] <= target && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public int binarySearch(int[] nums, int start, int end, int target){
        if(start <= end){
            int mid = (start + end) / 2;
            if(target == nums[mid]){
                return mid;
            }else if(nums[start] > nums[end]){
                int t1 = binarySearch(nums, mid+1, end, target);
                int t2 = binarySearch(nums, start, end-1, target);

                if(t1 == -1 && t2 == -1){
                    return -1;
                }else{
                    return t1 == -1 ? t2 : t1;
                }

            }else if(target > nums[mid]){
                return binarySearch(nums, mid+1, end, target);
            }else{
                return binarySearch(nums, start, end-1, target);
            }
        }
        return -1;
    }





    @Test
    public void t(){
        int[] n = {3, 4, 5, 6, 0, 1, 2};
        for(int i = 0; i < n.length; i++){
            System.out.println(n[i]+" = "+search(n, n[i]));
        }
    }
}
