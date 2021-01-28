package com.medium;

import com.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class M230_KthSmallestElementInABST {
    private int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return res;
    }

    public void inOrder(TreeNode root, int k){
        if(root == null){
            return;
        }
        inOrder(root.left, k);
        k--;
        if(k == 0){

            return;
        }
        inOrder(root.right, k);
    }


    public int kthSmallest2(TreeNode root, int k){
        Deque<TreeNode> st = new LinkedList<>();

        while (!st.isEmpty() || root != null){
            while(root != null){
                st.addLast(root);
                root = root.left;
            }
            if(!st.isEmpty()){
                root = st.removeLast();
                if(--k == 0) return root.val;
                root = root.right;
            }
        }
        return 0;
    }
}
