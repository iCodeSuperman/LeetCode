package com.medium;

import java.util.*;

public class M039_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); //排序-剪枝-提速
        recall(candidates, target, 0, new ArrayDeque<>(), res);
        return res;
    }

    // 原数组， 差值，下一个搜索起始点坐标，路径队列
    public void recall(int[] candidates, int delta, int begin,
                       Deque<Integer> path, List<List<Integer>> res){
        if(delta == 0){
            /**
             * 重要：由于 path 全局只使用一份，到叶子结点的时候需要做一个拷贝!!!
             */
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = begin; i < candidates.length; i++){
            if(delta - candidates[i] < 0){
                break;
            }
            /**
             * 重要：由于 path 全局只使用一份，加入递归后要删除。
             */
            path.addLast(candidates[i]);
            //注意：可以重复，用i; 不可以重复，用i+1
            recall(candidates, delta - candidates[i], i, path, res);
            path.removeLast();
        }

    }
}
