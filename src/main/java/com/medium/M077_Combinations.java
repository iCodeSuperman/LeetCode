package com.medium;

import java.sql.PreparedStatement;
import java.util.*;

public class M077_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n <= 0) return res;
        Deque<Integer> list = new ArrayDeque<>();
        dfs(n, k, 1, list, res);
        return res;
    }

    public void dfs(int n, int k, int start, Deque<Integer> list, List<List<Integer>> res){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }

        /**
         * n = 6, k = 4:
         *      when list.size = 1, 还需要3个，则最大搜索起点为4，最后一个可选择组合为[4, 5, 6]
         *      when list.size = 2, 还需要2个，则最大搜索起点为5，最后一个可选择组合为[5, 6]
         *      when list.size = 3, 还需要1个，则最大搜索起点为6，最后一个可选择组合为[6]
         */

        for(int i = start; i <= n - (k - list.size()) + 1; i++){
            list.addLast(i);
            dfs(n, k, i + 1, list, res);
            list.removeLast();
        }
    }
}
