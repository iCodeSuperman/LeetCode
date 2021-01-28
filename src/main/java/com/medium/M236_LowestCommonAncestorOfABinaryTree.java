package com.medium;

import com.domain.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class M236_LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        /**
         * 情况1：如果p和q都在以root为根的树中，那么left和right一定为p和q，参考base case
         */
        if(left != null && right != null){
            return root;
        }
        /**
         * 情况2：如果p和q都不在以root为根的树中，则返回null
         */
        if(left == null && right == null){
            return null;
        }
        /**
         * 情况3：如果p和q只有一个存在以root为根的树中，则返回存在的节点
         */
        return left == null ? right : left;
    }


    Map<Integer, TreeNode> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public void dfs(TreeNode root){
        if(root.left != null){
            map.put(root.left.val, root);
            dfs(root.left);
        }
        if(root.right != null){
            map.put(root.right.val, root);
            dfs(root.right);
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
        dfs(root);
        while(p != null){
            visited.add(p.val);
            p = map.get(p.val);
        }
        while (q != null) {
            if(visited.contains(q.val)){
                return q;
            }
            q = map.get(q.val);
        }
        return null;
    }
}
