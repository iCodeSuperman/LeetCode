package com.medium;

import com.domain.TreeNode;

public class M98_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    /*限定以root为根节点的子树，必须满足min.val <= root.val <= max.val */
    public boolean isValid(TreeNode root, TreeNode min, TreeNode max){
        if(root == null){
            return true;
        }

        //若root.val不符合max和min的限制，说明不是BST
        if(min != null && root.val <= min.val) return false;
        if(max != null && root.val >= max.val) return false;

        //限定左子树的最大值是root.val，右子树的最小值为root.val
        return isValid(root.left, min, root) && isValid(root.right, root, max);
    }
}
