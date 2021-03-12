package com.medium;

import java.util.*;

public class M046_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>(fac(len));

        if(len == 0){
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>(len);
        Set<Integer> used = new HashSet<>(len);
        dfs(nums, len, 0, path, used, res);
        return res;

    }

    public void dfs(int[] nums, int len, int depth, Deque<Integer> path,
                    Set<Integer> used, List<List<Integer>> res){
        if(len == depth){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < len; i++){
            if(!used.contains(i)){
                used.add(i);
                path.addLast(nums[i]);
                dfs(nums, len, depth + 1, path, used, res);
                path.removeLast();
                used.remove(i);
            }
        }

    }

    public int fac(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        int p = 1;
        for(int i = n; i >= 1; i--){
            p = p * i;
        }
        return p;
    }
}


class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        int len = nums.length;
        int[] used = new int[len];
        dfs(nums, used ,list, len, res);
        return res;
    }

    void dfs(int[] nums, int[] used, LinkedList<Integer> list, int len, List<List<Integer>> res){
        if(list.size() == len){
            res.add(new LinkedList<>(list));
            return;
        }

        for(int i = 0; i < len; i++){
            if(used[i] == 0){
                list.add(nums[i]);
                used[i] = 1;
                dfs(nums, used, list, len, res);
                used[i] = 0;
                list.removeLast();
            }
        }

        return;
    }
}