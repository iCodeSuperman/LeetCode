package com.medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class M016_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int nLen = nums.length;
        int closest = nums[0] + nums[1] + nums[2];
        for(int k = 0; k < nLen - 2; k++){ // k(-3) i(-2) j(-1)
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1;
            int j = nLen - 1;
            while(i < j){
                int sum = nums[i] + nums[k] + nums[j];
                if(Math.abs(target - sum) < Math.abs(target - closest)){
                    closest = sum;
                }
                if(target < sum){
                    while(i < j && nums[j] == nums[--j]);
                }else if(target > sum){
                    while(i < j && nums[i] == nums[++i]);
                }else{
                    return closest;
                }
            }
        }
        return closest;
    }

    @Test
    public void myt() {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 4));
    }
}
