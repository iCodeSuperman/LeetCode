package com.medium;

import com.domain.TreeNode;

import java.util.*;

public class M103BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        boolean flag = true;
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int len = queue.size();
            for(int i = 0; i < len; i++){
                TreeNode cur = queue.removeFirst();
                temp.add(cur.val);
                if(cur.left != null){
                    queue.addLast(cur.left);
                }
                if(cur.right != null){
                    queue.addLast(cur.right);
                }
            }
            if(!flag){
                Collections.reverse(temp);
            }
            res.add(temp);
            flag = !flag;
        }
        return res;
    }
}
