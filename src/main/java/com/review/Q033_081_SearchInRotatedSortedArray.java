package com.review;

public class Q033_081_SearchInRotatedSortedArray {

    /**
     * - 算法总思路
     * 规律1：将有序数组旋转成为两部分，一定有一部分[left, mid] or [mid, right]是有序的。
     * 规律2：中间位置mid，一定落在有序的区间
     *          [1 2 3 4 5]     [1 2 3 4]
     *          [5 1 2 3 4]     [4 1 2 3]
     *          [4 5 1 2 3]     [3 4 1 2]
     *          [3 4 5 1 2]     [2 3 4 1]
     *          [2 3 4 5 1]
     * 规律3：通过判断nums[mid]和nums[left]的大小关系，判断[left, mid]
     *       和[mid, right] 那个区间有序，在有序区间进行二分搜索。
     * 伪代码：
     *      if(nums[mid] == target){
     *          找到了，返回
     *      }
     *      if(nums[left] == nums[mid]{
     *          出现了重复元素的有序数组
     *          left++
     *          删除重复元素
     *          eg:[1 3 1 1 1]
     *          continue; //注意，一定要continue
     *      }
     *      if(nums[left] <= nums[mid]){
     *          左边[left, mid]有序，在这里二分。
     *          if(nums[left] <= target <nums[mid]){
     *              target一定在左边，缩小右边界right=mid-1;
     *          }else{
     *              target不在左边，尝试右边去搜索left=mid+1;
     *          }
     *      }else{
     *         右边[mid,right]有序，在这里二分
     *         if(nums[mid] < target <= nums[right]){
     *             target一定在右边，所有左边界left=mid+1;
     *         }else{
     *             target不在右边，尝试左边去搜索right=mid-1;
     *         }
     *      }
     */



    //不重复的有序数组，在某点旋转，找出target在数组中的下标
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }


        return -1;
    }

    //重复值的有序数组，在某点旋转，找出target是否在数组中
    public boolean search2(int[] nums, int target) {
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
            if(nums[left] == nums[mid]){
                left++;
                continue;
            }

            if(nums[left] < nums[mid]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }


        return false;
    }
}
