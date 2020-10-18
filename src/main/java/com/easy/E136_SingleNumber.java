package com.easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class E136_SingleNumber {
    public int singleNumber(int[] nums){
        // XOR
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            result ^= nums[i];
        }
        return result;
    }
    public int singleNumber2(int[] nums) {
        // MAP
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]) == false){
                map.put(nums[i], 1);
            }else{
                int counts = map.get(nums[i]) + 1;
                map.put(nums[i], counts);
            }
        }

        int element = -1;
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();
            if((Integer) entry.getValue() == 1){
                element = (Integer) entry.getKey();
            }
        }
        return element;
    }
}
