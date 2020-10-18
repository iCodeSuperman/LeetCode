package com.medium;

import com.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class M102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Deque<TreeNode> st = new ArrayDeque<>();
        st.addLast(root);
        while(!st.isEmpty()){
            int len = st.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < len; i++){
                TreeNode cur = st.removeFirst();
                list.add(cur.val);
                if(cur.left != null){
                    st.addLast(cur.left);
                }
                if(cur.right != null){
                    st.addLast(cur.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
