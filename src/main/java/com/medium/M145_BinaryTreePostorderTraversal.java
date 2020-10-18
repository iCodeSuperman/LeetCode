package com.medium;

import com.domain.TreeNode;

import java.util.*;

public class M145_BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res  = new ArrayList<>();
        if(root == null) return res;

        Deque<TreeNode> st1 = new ArrayDeque<>();
        Deque<TreeNode> st2 = new ArrayDeque<>();
        st1.addLast(root);
        while(!st1.isEmpty()){
            TreeNode cur = st1.removeLast();
            st2.addLast(cur);
            if(cur.left != null){
                st1.addLast(cur.left);
            }
            if(cur.right != null){
                st1.addLast(cur.right);
            }
        }
        while(!st2.isEmpty()){
            TreeNode cur = st2.removeLast();
            res.add(cur.val);
        }
        return res;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> output = new LinkedList<>();

        TreeNode cur = root;
        while (cur != null) {

            if (cur.left == null) {
                output.add(cur.val);
                cur = cur.right;
            }
            else {
                TreeNode pre = cur.left;
                //找到cur结点左子树中，最右侧的结点记为pre
                while ((pre.right != null) && (pre.right != cur)) {
                    pre = pre.right;
                }

                if (pre.right == null) { //如果pre的右指针为null，则指向cur，并输出
                    output.add(cur.val);
                    pre.right = cur;
                    cur = cur.left;
                }
                else{ //如果pre的右指针指向cur，则置为null
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        return output;
    }

}











