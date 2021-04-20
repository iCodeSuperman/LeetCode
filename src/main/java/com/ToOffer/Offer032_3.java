package com.ToOffer;

import com.domain.TreeNode;

import java.util.*;

public class Offer032_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        TreeNode node = root;
        queue.addLast(node);
        boolean flag = false;
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < len; i++){
                TreeNode cur = queue.removeFirst();
                tmp.add(cur.val);
                if(cur.left != null){
                    queue.addLast(cur.left);
                }
                if(cur.right != null){
                    queue.addLast(cur.right);
                }
            }
            if(flag){
                res.add(tmp);
                flag = true;
            }else{
                Collections.reverse(tmp);
                res.add(tmp);
                flag = false;
            }
        }
        return res;
    }
}
