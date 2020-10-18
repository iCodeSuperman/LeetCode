package com.medium;

import org.junit.Test;

import java.util.*;

public class M047_Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>(fab(len));
        if(len == 0){
            return res;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(nums, len, 0, used, path, res);

        return res;
    }

    int fab(int n){
        if(n == 0){
            return 1;
        }
        int sum = 1;
        for(int i = n; i >= 1; i--){
            sum = sum * i;
        }
        return sum;
    }

    void dfs(int[] nums, int len, int depth, boolean[] used,
             Deque<Integer> path, List<List<Integer>> res){
        if(depth == len){
            res.add(new ArrayList<>(path));
        }

        for(int i = 0; i < len; i++){
            if(used[i]){
                continue;
            }
            if(i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false){
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, used, path, res);
            used[i] = false;
            path.removeLast();
        }
    }

    @Test
    public void t(){
        int[] nums = {1, 1, 2};
        List<List<Integer>> lists = permuteUnique(nums);
        System.out.println(lists);
    }

}
