package com.medium;

import com.domain.TreeNode;

public class M105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private int[] pre;
    private int[] in;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.pre = preorder;
        this.in = inorder;
        return constructBinaryTree(0, pre.length - 1, 0, in.length - 1);
    }

    public TreeNode constructBinaryTree(int preStart, int preEnd, int inStart, int inEnd){
        if(preStart > preEnd){
            return null;
        }
        //1. 找出根节点
        int mid = -1;
        for(int i = inStart; i <= inEnd; i++){
            if(pre[preStart] == in[i]){
                mid = i;
                break;
            }
        }
        //2. 计算前序左子树偏移量
        int offset = mid - inStart;
        //3. 构造二叉树
        TreeNode root = new TreeNode(in[mid]);
        root.left = constructBinaryTree(preStart + 1, preStart + offset, inStart, mid - 1);
        root.right = constructBinaryTree(preStart + 1 + offset, preEnd, mid + 1, inEnd);

        return root;
    }
}
