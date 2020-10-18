package com.medium;

import com.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class M144_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res  = new ArrayList<>();
        if(root == null) return res;

        Deque<TreeNode> st = new ArrayDeque<>();
        st.addLast(root);
        while(!st.isEmpty()){
            TreeNode cur = st.removeLast();
            res.add(cur.val);
            if(cur.right != null){
                st.addLast(cur.right);
            }
            if(cur.left != null){
                st.addLast(cur.left);
            }
        }
        return res;
    }

    public List<Integer> preorderTraversal2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        TreeNode cur = root;
        while(cur != null){
            // cur左子树为空，输出，cur=cur.right;
            // cur左子树不为空，寻找左子树最右侧结点
            if(cur.left == null){
                res.add(cur.val);
                cur = cur.right;
            }else {
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }

                //pre的右孩子为null，则指向cur
                //pre的右孩子指向cur，则置为null
                if (pre.right == null) {
                    pre.right = cur;
                    res.add(cur.val);
                    cur = cur.left;
                } else if(pre.right == cur){
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}












