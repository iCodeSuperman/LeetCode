package com.ToOffer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Offer039 {
    public int majorityElement1(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            int count = map.getOrDefault(nums[i], 0) + 1;
            if(count > len / 2){
                return nums[i];
            }
            map.put(nums[i], count);
        }

        return -1;
    }

    public int majorityElement(int[] nums) {
        int votes = 0;
        int x = 0;
        for(int i = 0; i < nums.length; i++){
            if(votes == 0){
                x = nums[i];
            }
            if(x == nums[i]){
                votes ++;
            }else {
                votes --;
            }
        }
        return x;
    }

    @Test
    public void t(){
        String a = "a1234";
        Integer integer = Integer.valueOf(a);
        int b = Integer.parseInt(a);

        System.out.println(integer);
        System.out.println(b);
        System.out.println(integer == b);
    }
}
