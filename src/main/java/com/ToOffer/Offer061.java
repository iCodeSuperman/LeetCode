package com.ToOffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author icodeboy
 */
public class Offer061 {
    public boolean isStraight2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = 14, max = -1;
        for (int n : nums) {
            if(n == 0){
                continue;
            }
            min = min < n ? min : n;
            max = max > n ? max : n;
            if(set.contains(n)){
                return false;
            }
            set.add(n);
        }
        if(max - min < 5){
            return true;
        }
        return false;
    }



    public boolean isStraight(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        int min = 14;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if(nums[i] == 0){
                count++;
            }else{
                map.put(nums[i], 1);
                min = min < nums[i] ? min : nums[i];
            }
        }

        for (int i = min; i < min + len; i++) {
            if(!map.containsKey(i)){
                if(count > 0){
                    count--;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
