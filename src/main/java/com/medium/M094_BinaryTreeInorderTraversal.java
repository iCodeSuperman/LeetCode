package com.medium;

import com.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class M094_BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode p = root;
        while(!st.isEmpty() || p != null){
            while(p !=null){
                st.push(p);
                p = p.left;
            }
            if(!st.isEmpty()){
                p = st.pop();
                res.add(p.val);
                p = p.right;
            }
        }

        return res;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
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
                    //res.add(cur.val); //前序遍历放这里输出
                    cur = cur.left;
                } else if(pre.right == cur){
                    pre.right = null;
                    res.add(cur.val); //中序遍历放这里输出
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}
