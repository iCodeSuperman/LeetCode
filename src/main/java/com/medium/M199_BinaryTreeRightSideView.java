package com.medium;

import com.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class M199_BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            TreeNode cur;
            for(int i = 0; i < len; i++){
                cur = queue.removeFirst();
                if(i == len - 1){
                    res.add(cur.val);
                }
                if(cur.left != null){
                    queue.addLast(cur.left);
                }
                if(cur.right != null){
                    queue.addLast(cur.right);
                }
            }
        }
        return res;
    }
}
