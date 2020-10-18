package com.easy;

import com.domain.TreeNode;

public class E111_MinimumDepthOfBinaryTree {
    private int mDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        postOrder(root, 1);
        return mDepth;
    }

    public void postOrder(TreeNode root, int depth){
        if(root.left == null && root.right == null){
            mDepth = mDepth < depth ? mDepth : depth;
            return;
        }
        if(root.left != null){
            postOrder(root.left, depth + 1);
        }
        if(root.right != null){
            postOrder(root.right, depth + 1);
        }
    }
}
