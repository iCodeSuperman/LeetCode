package com.medium;

import com.domain.TreeNode;

public class M106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    private int in[];
    private int post[];
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.in = inorder;
        this.post = postorder;
        return ConstructBinaryTree(0, in.length - 1, 0, post.length - 1);
    }

    public TreeNode ConstructBinaryTree(int inStart, int inEnd, int postStart, int postEnd){
        if(postStart > postEnd){
            return null;
        }
        int mid = -1;
        for(int i = inStart; i <= inEnd; i++){
            if(post[postEnd] == in[i]){
                mid = i;
                break;
            }
        }

        int offset = mid - inStart;

        TreeNode root = new TreeNode(in[mid]);
        root.left = ConstructBinaryTree(inStart, mid - 1, postStart, postStart + offset - 1);
        root.right = ConstructBinaryTree(mid + 1, inEnd, postStart + offset, postEnd - 1);
        return root;
    }
}
