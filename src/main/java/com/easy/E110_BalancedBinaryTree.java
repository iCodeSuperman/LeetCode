package com.easy;

import com.domain.TreeNode;

public class E110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return postOrder(root);
    }

    public boolean postOrder(TreeNode root){
        if(root == null){
            return true;
        }

        boolean lb = postOrder(root.left);
        boolean rb = postOrder(root.right);
        if(!(lb && rb)){
            /**
             * F && F = F
             * F && T = F
             * T && F = F
             * T && T = T - 这个排除
             */
            return false;
        }

        int lh = treeHeight(root.left);
        int rh = treeHeight(root.right);
        if(Math.abs(lh - rh) > 1){
            return false;
        }

        return true;
    }

    public int treeHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = treeHeight(root.left);
        int rh = treeHeight(root.right);
        return (lh > rh? lh : rh) + 1;
    }


}
