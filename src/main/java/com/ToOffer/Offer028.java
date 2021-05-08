package com.ToOffer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author icodeboy
 */
public class Offer028 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        mirrorTree(root.right);
        return doublePost(root.left, root.right);
    }

    public boolean doublePost(TreeNode root1, TreeNode root2){
        if(root1 == null || root2 == null){
            if(root1 == root2){
                return true;
            }else{
                return false;
            }
        }

        if(root1.val != root2.val){
            return false;
        }

        boolean left = doublePost(root1.left, root2.left);
        if(!left){
            return false;
        }

        boolean right = doublePost(root1.right, root2.right);

        return left && right;
    }

    public void mirrorTree(TreeNode root){
        if(root == null){
            return;
        }
        mirrorTree(root.left);
        mirrorTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
