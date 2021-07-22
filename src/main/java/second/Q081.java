package second;


public class Q081 {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int len = nums.length;
        int left = 0, right = len - 1;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(target == nums[mid]){
                return true;
            }

            if(nums[left] == nums[mid]){
                left++;
                continue;
            }

            // 前半段有序
            if(nums[left] < nums[mid]){
                // 先看看target在不在这里
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
