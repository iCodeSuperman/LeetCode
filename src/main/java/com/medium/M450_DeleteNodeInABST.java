package com.medium;

import com.domain.TreeNode;

public class M450_DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }

        if(root.val == key){
            if(root.left == null) {
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            TreeNode min = getMinNode(root.right);
            root.val = min.val;
            root.right = deleteNode(root.right, min.val);

        }else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else{
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    public TreeNode getMinNode(TreeNode root){
        TreeNode p = root;
        while(p.right != null){
            p = p.right;
        }
        return p;
    }
}
