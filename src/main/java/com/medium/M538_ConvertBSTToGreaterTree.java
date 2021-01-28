package com.medium;

import com.domain.TreeNode;

import java.util.LinkedList;

public class M538_ConvertBSTToGreaterTree {
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        inOrder(root);
        return root;
    }
    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.right);
        sum += root.val;
        root.val = sum;
        inOrder(root.left);
    }

    public void inOrder2(TreeNode root){
        LinkedList<TreeNode> st = new LinkedList<>();
        while(!st.isEmpty() || root != null){
            while(root != null){
                st.addLast(root);
                root = root.right;
            }
            if(!st.isEmpty()){
                root = st.removeLast();
                sum += root.val;
                root.val = sum;
                root = root.left;
            }
        }
    }

    public void inOrderByMorris(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur != null){
            if(cur.right == null){
                sum += cur.val;
                cur.val = sum;
                cur = cur.left;
            }else{
                pre = cur.right;
                while(pre.left != null && pre.left != cur){
                    pre = pre.left;
                }
                if(pre.left == null){
                    pre.left = cur;
                    cur = cur.right;
                }else{
                    pre.left = null;
                    sum += cur.val;
                    cur.val = sum;
                    cur = cur.left;
                }
            }
        }
    }

}
