package second;


import org.junit.Test;

public class Q033 {

    public int search02(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int len = nums.length;
        int left = 0, right = len - 1;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(target == nums[mid]){
               return mid;
            }
            // 前半段有序
            if(nums[left] <= nums[mid]){
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
        return -1;
    }


    private int index = -1;
    public int search(int[] nums, int target) {
        find(nums, 0, nums.length - 1, target);
        //t();
        return index;
    }

    public void find(int[] nums, int left, int right, int target){
        //System.out.println("left="+left+"; right="+right);
        if(left > right){
            return;
        }
        if(nums[left] > nums[right]){
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target){
                index = mid;
                return;
            }

            if(nums[left] > nums[mid]){
                find(nums, left, mid - 1, target);
            }else{
                binarySearch(nums, left, mid - 1, target);
            }

            if(nums[mid] > nums[right]){
                find(nums, mid + 1, right, target);
            }else{
                binarySearch(nums, mid + 1, right, target);
            }

        }else{
            binarySearch(nums, left, right, target);
        }
    }

    public void binarySearch(int[] nums, int left, int right, int target){
        //System.out.println(" ==二分== left="+left+"; right="+right);
        if(left > right){
            return;
        }
        int l = left;
        int r = right;
        while(l < r){
            int mid = (r - l) / 2 + l;
            int val = nums[mid];
            if(target == val){
                // System.out.println("mid = " + mid);
                index = mid;
                return;
            }else if(target > val){
                l = mid + 1;
            }else if(target < val){
                r = mid - 1;
            }
        }
        if(nums[l] == target){
            index = l;
            //System.out.println("index="+l);
        }
    }

    @Test
    public void t(){
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(this.search(nums, target));
    }
}
