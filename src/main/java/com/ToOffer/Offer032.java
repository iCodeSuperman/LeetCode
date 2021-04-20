package com.ToOffer;

import com.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Offer032 {
    public int[] levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return new int[0];
        }
        TreeNode node = root;
        queue.addLast(node);

        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i < len; i++){
                TreeNode cur = queue.removeFirst();
                res.add(cur.val);
                if(cur.left != null){
                    queue.addLast(cur.left);
                }
                if(cur.right != null){
                    queue.addLast(cur.right);
                }
            }
        }

        int[] arr = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            arr[i] = res.get(i);
        }
        return arr;
    }
}
