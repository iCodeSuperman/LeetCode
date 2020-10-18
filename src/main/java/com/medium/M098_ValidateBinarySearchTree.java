package com.medium;

import com.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class M098_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> st = new ArrayDeque<>();
        double preval = - Double.MIN_VALUE;
        if(root != null){
            TreeNode p = root;
            while(!st.isEmpty() || p != null){
                while(p != null){
                    st.addLast(p);
                    p = p.left;
                }
                if(!st.isEmpty()){
                    p = st.removeLast();
                    if(p.val <= preval) return false;
                    preval = p.val;
                    p = p.right;
                }
            }
        }
        return true;
    }
}
