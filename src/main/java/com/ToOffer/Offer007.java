package com.ToOffer;

public class Offer007 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length -1, 0, inorder.length - 1);
    }

    public TreeNode build(int[] pre, int[] in, int preL, int preR, int inL, int inR){
        TreeNode root = new TreeNode(pre[0]);
        int mid = -1;
        for (int i = 0; i < in.length; i++) {
            if(in[i] == pre[0]){
                mid = i;
                break;
            }
        }
        int offset = mid - inL;

        root.left = build(pre, in, preL + 1, preL + offset, inL, mid - 1);
        root.right = build(pre, in, preL + offset + 1, preR, mid + 1, inR);
        return root;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
