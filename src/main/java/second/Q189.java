package second;

public class Q189 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if(k >= len){
            return;
        }
        reserve(nums, 0, k);
        reserve(nums, k + 1, len - 1);
        reserve(nums, 0, len - 1);
    }

    public void reserve(int[] nums, int left, int right){
        while(left < right){
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left ++;
            right --;
        }
    }
}

