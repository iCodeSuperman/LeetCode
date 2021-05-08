package com.ToOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author icodeboy
 */
public class Offer068_2 {
    List<Deque<TreeNode>> list = new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> temp = new ArrayDeque<>();
        preOrder(root, p, temp);
        preOrder(root, q, temp);

        Deque<TreeNode> pSt = list.get(0);
        Deque<TreeNode> qSt = list.get(1);
        while(pSt.size() > qSt.size()){
            pSt.removeLast();
        }
        while(pSt.size() < qSt.size()){
            qSt.removeLast();
        }

        while(pSt.getLast().val != qSt.getLast().val){
            pSt.removeLast();
            qSt.removeLast();
        }
        return qSt.removeLast();
    }
    public void preOrder(TreeNode root, TreeNode target, Deque<TreeNode> st){
        if(root == null) {
            return;
        }
        st.addLast(root);
        if(root.val == target.val) {
            list.add(new ArrayDeque<>(st));
            st.removeLast();
            return;
        }

        preOrder(root.right, target, st);
        preOrder(root.left, target, st);
        st.removeLast();
    }

}
