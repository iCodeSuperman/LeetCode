package com.medium;

public class M075_SortColors {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if(len < 2){
            return;
        }

        /*
        all in [0, zero) = 0;
        all in [zero, i) = 1;
        all in [two, len - 1] = 2;
        */
        // 为了保证初始化的时候 [0, zero) 为空，设置 zero = 0，
        // 所以下面遍历到 0 的时候，先交换，再++(zero指向0的位置，现将1换过来，在移动）
        int zero = 0;

        // 为了保证初始化的时候 [two, len - 1] 为空，设置 two = len
        // 所以下面遍历到 2 的时候，先--，再交换(two指向len位置，所以要先移动，才能放值)
        int two = len;

        // 循环终止条件是 i == two，那么循环可以继续的条件是 i < two
        // 当 i == two 上面的三个子区间正好覆盖了全部数组
        int i = 0;

        while(i < two){
            if(nums[i] == 0){
                swap(nums, zero, i);
                zero++;
                i++;
            }else if(nums[i] == 1){
                i++;
            }else{
                two--;
                swap(nums, i, two);
            }
        }
    }

    public void swap(int[]nums, int left, int right){
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left]  = temp;
    }
}
