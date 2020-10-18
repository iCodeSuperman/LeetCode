package com.easy;

import com.domain.TreeNode;
import com.tool.TreeOrder;

import java.util.LinkedList;
import java.util.Queue;

public class E104_MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {

        //return myOrder(root, 1);
        return postOrder(root);
    }

    public int myOrder(TreeNode root, int depth){
        if(root == null){
            return depth - 1;
        }
        int hl = myOrder(root.left, depth+1);
        int hr = myOrder(root.right, depth+1);

        return (hl > hr ? hl : hr);
    }

    public int postOrder(TreeNode root){
        if(root == null){
            return 0;
        }
        int hl = postOrder(root.left) + 1;
        int hr = postOrder(root.right) + 1;

        return (hl > hr ? hl : hr);
    }

    public void LayerOrder(TreeNode root, int depth){
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode now = q.poll();
            if(now.left != null){
                q.offer(now.left);
            }
            if(now.right != null){
                q.offer(now.right);
            }
        }
    }

}
