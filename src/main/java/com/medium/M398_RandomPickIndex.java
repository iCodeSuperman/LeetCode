package com.medium;


import javax.management.remote.rmi._RMIConnection_Stub;
import java.util.Random;

public class M398_RandomPickIndex {
}

class Solution {

    int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        Random r = new Random();
        int count = 0; // 用来记录当前数组中，有几个元素和target一样
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(target == nums[i]){
                count++;
                if(r.nextInt(count) == 0) {
                    res = i;
                }
            }
        }
        return res;
    }
}
