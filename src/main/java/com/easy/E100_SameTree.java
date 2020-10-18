package com.easy;

import com.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class E100_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            // 两个都为空，相同
            return true;
        }
        if(p == null || q == null){
            // 有且仅有一个为空，不相同
            return false;
        }
        if(q.val != p.val){
            // 注意：这里仅能判断结点值不同，返回false。不能判断相同而返回true
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        ArrayList<Integer> lp = new ArrayList<Integer>();
        ArrayList<Integer> lq = new ArrayList<Integer>();
        lp = LayerOrder(p);
        lq = LayerOrder(q);
        if(lp.size() != lq.size()){
            return false;
        }else{
            for(int i = 0; i < lp.size(); i++){
                if(lp.get(i) != lq.get(i)){
                    return false;
                }
            }
        }
        return true;
    }

    public ArrayList<Integer> LayerOrder(TreeNode root){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode now = q.poll();
            list.add(now.val);
            if(now.left != null){
                q.offer(now.left);
            }
            if(now.right != null){
                q.offer(now.right);
            }
        }
        return list;
    }
}
