package com.ToOffer;

import com.domain.TreeNode;

/**
 * @author icodeboy
 */
public class Offer055_2 {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) == -1 ? false : true;
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        // 剪枝
        if(left == -1){
            return -1;
        }

        int right = dfs(root.right);
        // 剪枝
        if(right == -1){
            return -1;
        }

        return Math.abs(left - right) >= 2 ? -1 : Math.max(left, right) + 1;
    }
}
