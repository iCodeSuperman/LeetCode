package com.medium;

import com.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class M173_BinarySearchTreeIterator {
    Deque<TreeNode> st;
    public M173_BinarySearchTreeIterator(TreeNode root){
        st = new ArrayDeque<>();

        leftMost(root);
    }

    public void leftMost(TreeNode root){
        while(root != null){
            st.addLast(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = st.removeLast();
        if(cur.right != null){
            leftMost(cur.right);
        }
        return cur.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return st.size() > 0;
    }
}
