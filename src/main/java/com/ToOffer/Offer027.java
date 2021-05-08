package com.ToOffer;

/**
 * @author icodeboy
 */
public class Offer027 {
    public TreeNode mirrorTree(TreeNode root) {
        post(root);
        return root;
    }

    public void post(TreeNode root){
        if(root == null){
            return;
        }
        post(root.left);
        post(root.right);



        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
