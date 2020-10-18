package com.easy;

import com.domain.TreeNode;

public class E112_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return postOrder(root, sum);
    }

    public Boolean postOrder(TreeNode root, int sum){
        if(root.left == null && root.right == null){
            if(sum - root.val == 0){
                return true;
            }
            return false;
        }
        Boolean leftBool = false, rightBool = false;
        if(root.left != null){
            leftBool = postOrder(root.left, sum - root.val);
        }

        if(root.right != null){
            rightBool = postOrder(root.right, sum - root.val);
        }

        return leftBool || rightBool;
    }

}
