package com.medium;

import org.junit.Test;

public class M031_NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i >= 0 && nums[i+1] <= nums[i]){
            i--;
        }

        if(i >= 0){
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]){
                // i   j   i j
                // 2 3 1   2 3 1;  存在i位值比j位大时，不能交换！
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int begin){
        int j = nums.length - 1;
        while(begin < j){
            swap(nums, begin, j);
            begin++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    @Test
    public void t(){
        int[] nums = {1};
        nextPermutation(nums);
        for (int num : nums) {
            System.out.println(num + " ");
        }
        System.out.println();
    }
}
