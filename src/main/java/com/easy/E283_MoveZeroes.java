package com.easy;

public class E283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while(fast < nums.length){
            if(nums[fast] != 0){
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            fast++;
        }
    }
}
