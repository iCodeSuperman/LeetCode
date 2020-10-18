package com.medium;

import com.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class M113_PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        recall(res, path, root, 0, sum);
        return res;
    }

    public void recall(List<List<Integer>> res, Deque<Integer> path,
                       TreeNode root, int value, int sum){
        if(root == null){
            return;
        }
        path.addLast(root.val);
        if(root.left == null && root.right == null){
            if(value == sum){
                res.add(new ArrayList<>(path));
            }
        }
        recall(res, path, root.left, value + root.val, sum);
        recall(res, path, root.right, value + root.val, sum);
        path.removeLast();
    }
}
