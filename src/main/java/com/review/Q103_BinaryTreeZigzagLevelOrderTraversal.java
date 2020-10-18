package com.review;

import com.domain.TreeNode;

import java.util.*;

public class Q103_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();

        if(root == null){
            return lists;
        }

        Deque<TreeNode> st = new ArrayDeque<>();
        st.addLast(root);
        boolean flag = true;

        while(!st.isEmpty()){
            int len = st.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < len; i++){
               TreeNode node = st.removeFirst();
               list.add(node.val);
               if(node.left != null){
                   st.addLast(node.left);
               }
               if(node.right != null){
                   st.addLast(node.right);
               }
            }
            if(flag == false){
                Collections.reverse(list);
                flag = true;
            }else{
                flag = false;
            }

            lists.add(list);
        }

        return lists;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();

        if(root == null){
            return lists;
        }

        Deque<TreeNode> st = new ArrayDeque<>();
        st.addLast(root);
        boolean flag = true;

        while(!st.isEmpty()) {
            int len = st.size();
            List<Integer> list = new ArrayList<>();

            if (flag == true) {
                // 从前面取出父节点，从后面添加子节点；同时左子树先进，右子树后进
                for (int i = 0; i < len; i++) {
                    TreeNode node = st.removeFirst();
                    list.add(node.val);
                    if (node.left != null) {
                        st.addLast(node.left);
                    }
                    if (node.right != null) {
                        st.addLast(node.right);
                    }
                }
                lists.add(list);
                flag = false;
            } else {
                // 从后面取出父节点，从前面添加子节点；同时右子树先进
                for (int i = 0; i < len; i++) {
                    TreeNode node = st.removeLast();
                    list.add(node.val);
                    if (node.right != null) {
                        st.addFirst(node.right);
                    }
                    if (node.left != null) {
                        st.addFirst(node.left);
                    }

                }
                lists.add(list);
                flag = true;
            }
        }

        return lists;
    }

}
