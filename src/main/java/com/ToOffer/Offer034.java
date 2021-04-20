package com.ToOffer;

import com.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Offer034 {
    private List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        dfs(root, target, 0, new ArrayDeque<>());
        return res;
    }

    public void dfs(TreeNode root, int target, int sum, Deque<Integer> path){
        if(root == null){
            return;
        }

        sum += root.val;
        path.addLast(root.val);
        if(root.left == null && root.right == null && sum == target){
            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        dfs(root.left, target, sum, path);
        dfs(root.right, target, sum, path);
        path.removeLast();
    }
}
