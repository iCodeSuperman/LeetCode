package com.ToOffer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * @author icodeboy
 */
public class Offer068_1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
            if(p.val > root.val && q.val > root.val){
                root = root.right;
            }else if(p.val < root.val && q.val < root.val){
                root = root.left;
            }else{
                break;
            }
        }
        return root;
    }

}
