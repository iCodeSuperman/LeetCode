package com.medium;

import com.domain.TreeNode;

public class M222_CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int hl = 0, hr = 0;
        while(left != null){
            left = left.left;
            hl ++;
        }
        while(right != null){
            right = right.right;
            hr ++;
        }
        if(hl == hr){
            return (int)Math.pow(2, hl) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
