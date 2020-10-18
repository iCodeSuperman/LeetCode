package com.easy;

import com.domain.TreeNode;

import java.util.*;

public class E107_BinaryTreeLevelOrderTraversal2 {
    private List<List<Integer>> list = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        postOrder(root, 0);
        Collections.reverse(list);
        return list;
    }

    public void postOrder(TreeNode root, int depth){
        if(root == null){
            return;
        }
        // 核心，什么时候添加一个链表
        if(list.size() <= depth) list.add(new ArrayList<Integer>());
        postOrder(root.left, depth + 1);
        postOrder(root.right, depth + 1);
        list.get(depth).add(root.val);
    }
}
