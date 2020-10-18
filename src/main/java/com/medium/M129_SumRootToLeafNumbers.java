package com.medium;

import com.domain.TreeNode;

public class M129_SumRootToLeafNumbers {
    private int sum;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        recall(root, 0);
        return sum;
    }
    public void recall(TreeNode root, int nowNumber){
        if(root.left == null && root.right == null){
            sum += nowNumber * 10 + root.val;
            return;
        }
        if(root.left != null){
            recall(root.left, nowNumber * 10 + root.val);
        }
        if(root.right != null){
            recall(root.right, nowNumber * 10 + root.val);
        }
    }
}
