package com.ToOffer;

import com.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Offer032_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        TreeNode node = root;
        queue.addLast(node);

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
            res.add(tmp);
        }
        return res;

    }
}
