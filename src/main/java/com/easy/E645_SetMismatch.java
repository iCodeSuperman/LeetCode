package com.easy;

import org.junit.Test;

import java.util.Arrays;

public class E645_SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1; // 取出nums中的值，转换成坐标

            int elem = nums[index];
            if(elem < 0){
                res[0] = index + 1;
            }else{
                nums[index] = -elem;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                res[1] = i + 1;
            }
        }

        return res;
    }

    @Test
    public void t(){
        int[] test = {1, 4, 2, 2};
        System.out.println(Arrays.toString(this.findErrorNums(test)));
    }
}
