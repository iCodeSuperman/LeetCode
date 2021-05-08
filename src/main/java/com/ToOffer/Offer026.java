package com.ToOffer;

/**
 * @author icodeboy
 */
public class Offer026 {
    boolean result1;
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        preOrder(A, B);
        return result1;
    }

    public void preOrder(TreeNode root, TreeNode B){
        if(root == null){
            return;
        }
        if(root.val == B.val && subStructure(root, B)){
            result1 = true;
            return;
        }
        preOrder(root.left, B);
        preOrder(root.right, B);
    }

    public boolean subStructure(TreeNode A, TreeNode B){
        if(A == null && B != null){
            return false;
        }
        if(B == null){
            return true;
        }
        return A.val == B.val && subStructure(A.left, B.left) && subStructure(A.right, B.right);
    }
}
