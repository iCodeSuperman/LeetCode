package com.easy;

import com.domain.TreeNode;
import com.tool.TreeOrder;

public class E101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isEqual(root.left, root.right);
    }

    public boolean isEqual(TreeNode l, TreeNode r){
        if(l == null && r == null){
            return true;
        }
        if(l == null || r == null){
            return false;
        }
        if(l.val != r.val){
            return false;
        }
        return isEqual(l.left, r.right) &&
                isEqual(l.right, r.left);
    }
}
