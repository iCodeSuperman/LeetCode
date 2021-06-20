package second;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * 215. 数组中的第K个最大元素
 * M
 * @author icodeboy
 */
public class Q215 {



    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    private static Random random = new Random(System.currentTimeMillis());
    public int findKthLargest(int[] nums, int k){
        // quickSort(nums, 0, nums.length - 1);
        // for (int i = 0; i < nums.length; i++) {
        //     System.out.println(nums[i]);
        // }
        // return nums[nums.length - k];
        int len = nums.length;
        int target = len - k;
        int right = len - 1;
        int left = 0;
        while(left < right){
            int index = quickSort(nums, left, right);
            if(index == target){
                return nums[index];
            }else if(index < target){
                left = index + 1;
            }else{
                right = index - 1;
            }
        }
        return nums[left];
    }

    public int quickSort(int[] nums, int left, int right){
        if(left > right) {
            return -1;
        }

        if (right > left) {
            int randomIndex = left + 1 + random.nextInt(right - left);
            swap(nums, left, randomIndex);
        }

        int pivot  = nums[left];
        int i = left;
        int j = right;
        while(i < j){
            while (i < j && nums[j] >= pivot){
                j--;
            }
            swap(nums, i, j);

            while(i < j && nums[i] <= pivot){
                i++;
            }
            swap(nums, i, j);
        }
        nums[i] = pivot;
        // quickSort(nums, left, i - 1);
        // quickSort(nums, i + 1, right);
        return i;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void t(){
        int[] arr = {3,2,3,1,2,4,5,5,6};
        System.out.println(this.findKthLargest(arr, 4));
    }
}
