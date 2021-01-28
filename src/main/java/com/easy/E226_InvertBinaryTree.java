package com.easy;

import com.domain.ListNode;
import com.domain.TreeNode;

public class E226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
       if(root == null){
           return null;
       }
       swap(root);
       return root;
    }
    public void swap(TreeNode root){
        if(root == null){
            return;
        }
        swap(root.left);
        swap(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
