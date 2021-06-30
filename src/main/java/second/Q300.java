package second;

/**
 * 300 最长递增子序列
 * @author icodeboy
 */
public class Q300 {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        // 原来数组的长度
        int len = nums.length;
        // 子序列数组
        int[] arr = new int[len];
        // k为子序列数组末尾元素的下标，k+1为数组长度;
        int k = 0;

        arr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            // 大于arr的尾元素，直接插到末尾
            if(nums[i] > arr[k]){
                k++;
                arr[k] = nums[i];
            }else if(nums[i] == arr[k]){
                // 等于最后一个，什么都不做
            }else if(nums[i] < arr[k]){
                int index = findIndex(nums[i], arr, k);
                nums[index] = nums[i];
            }
        }
        return k + 1;
    }

    /**
     * 寻找子序列数组arr中，第一个比target大的数组元素下标
     * @param target
     * @param arr
     * @param k
     * @return
     */
    public int findIndex(int target, int[] arr, int k){
        int left = 0, right = k;
        while(left < right){
            int mid = (right - left) / 2 + left;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                right = mid;
            }else if(arr[mid] < target){
                left = mid + 1;
            }
        }
        return left;
    }
}
