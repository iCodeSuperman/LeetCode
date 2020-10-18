package com.tool;

import com.domain.TreeNode;

public class TreeOrder {

    public static void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

}
