package com.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class E001_TwoSum {
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int DValue;
        for(int i = 0; i < nums.length; i++){
            DValue = target - nums[i];
            if(map.containsKey(DValue)){
                return new int[]{map.get(DValue), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
