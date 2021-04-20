package com.ToOffer;

import com.domain.TreeNode;

/**
 * @author icodeboy
 */
public class Offer055 {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        return 1 + (left > right ? left : right);
    }
}
