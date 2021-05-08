package com.ToOffer;

/**
 * @author icodeboy
 */
public class Offer054 {
    TreeNode res;
    public int kthLargest(TreeNode root, int k) {
        inOrder(root, k--);
        return res.val;
    }
    public void inOrder(TreeNode root, int k){
        if(root == null){
            return;
        }
        inOrder(root.right, k--);
        if(k == 0){
            res = root;
            return;
        }
        inOrder(root.left, k--);
    }
}
