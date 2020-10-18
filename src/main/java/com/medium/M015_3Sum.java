package com.medium;


import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M015_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int nlen = nums.length;
        for(int k = 0; k < nlen; k++){
            if(nums[k] > 0) break;
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1;
            int j = nlen - 1;
            int value = 0 - nums[k];
            while(i < j){
                int sum = nums[i] + nums[j];
                if(sum < value){
                    while(i < j && nums[i] == nums[++i]);
                }else if(sum > value){
                    while(i < j && nums[j] == nums[--j]);
                }else{
                    lists.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return lists;
    }

    @Test
    public void myt() {
        int[] nums = {0, 0, 1, 0, -1, 0, 0, 0, 0, 0};
        List<List<Integer>> lists = threeSum(nums);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
