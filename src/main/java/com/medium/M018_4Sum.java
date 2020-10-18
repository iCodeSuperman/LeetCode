package com.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M018_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int nLen = nums.length;
        Arrays.sort(nums);

        for(int i = 0; i < nLen - 3; i++){
            //去重-去掉0000这类重复的解
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            for(int j = i + 1; j < nLen - 2; j++){
                if(j > i+1 && nums[j] == nums[j - 1]) continue; //去重
                int p = j + 1;
                int q = nLen - 1;
                while(p < q){
                    int sum = nums[i] + nums[j] + nums[p] + nums[q];
                    if(sum < target){
                        while(p < q && nums[p] == nums[++p]); //去重
                    }else if(sum > target){
                        while(p < q && nums[q] == nums[--q]); //去重
                    }else{
                        res.add(new ArrayList(
                                Arrays.asList(nums[i], nums[j], nums[p], nums[q])));
                        while(p < q && nums[p] == nums[++p]); //去重
                        while(p < q && nums[q] == nums[--q]); //去重
                    }

                }//while(pq)
            }//for-j
        }//for-i

        return res;
    }

}
