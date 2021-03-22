package com.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class M078_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        dfs(nums, 0, list, res);
        return res;
    }

    public void dfs(int[] nums, int start, LinkedList<Integer> list, List<List<Integer>> res){
        res.add(new LinkedList<>(list));

        for(int i = start; i < nums.length; i++){
            list.addLast(nums[i]);
            dfs(nums, i + 1, list, res);
            list.removeLast();
        }
    }
}
