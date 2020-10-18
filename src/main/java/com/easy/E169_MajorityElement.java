package com.easy;

import java.util.HashMap;
import java.util.Map;

public class E169_MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                int count = map.get(nums[i]);
                count += 1;
                map.put(nums[i], count);
            }else{
                map.put(nums[i], 1);
            }
        }

        int majority = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > nums.length / 2){
                majority = entry.getKey();
            }
        }
        return majority;
    }
}
