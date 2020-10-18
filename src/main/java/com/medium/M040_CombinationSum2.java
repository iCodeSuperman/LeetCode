package com.medium;

import java.util.*;

public class M040_CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        callback(candidates, 0, target, new ArrayDeque<Integer>(), res);
        return res;
    }

    /**
     * @param candidates 候选数组
     * @param begin      从候选数组的 begin 位置开始搜索(注意不可重复为下一个）
     * @param delta      表示剩余，这个值一开始等于 target，基于题目中说明的"所有数字（包括目标数）都是正整数"这个条件
     * @param path       从根结点到叶子结点的路径
     * @param res        结果集
     */
    public void callback(int[] candidates, int begin, int delta,
                         Deque<Integer> path, List<List<Integer>> res){
        if(delta == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = begin; i < candidates.length; i++){
            if(delta - candidates[i] < 0){
                break;
            }
            if(i > begin && candidates[i-1] == candidates[i]){
                continue;
            }
            path.addLast(candidates[i]);
            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            callback(candidates, i+1, delta - candidates[i], path, res);
            path.removeLast();
        }

    }
}
