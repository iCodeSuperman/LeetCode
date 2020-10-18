package com.hard;

import com.domain.TreeNode;

public class H124_BinaryTreeMaximumPathSum {
    private int globeMax = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        solve(root);
        return globeMax;
    }

    public int solve(TreeNode root){
        if(root == null){
            return 0;
        }
        //仅仅在子树路径和大于0才加入。负值不如不要！！！
        int leftMax = Math.max(solve(root.left), 0);
        int rightMax = Math.max(solve(root.right), 0);
        int sum = leftMax + rightMax + root.val;
        if(globeMax < sum){
            globeMax = sum;
        }
        int rtMax = leftMax >= rightMax ? leftMax : rightMax;
        return rtMax + root.val;
    }

}
