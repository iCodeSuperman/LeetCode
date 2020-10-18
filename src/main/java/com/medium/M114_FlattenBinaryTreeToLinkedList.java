package com.medium;

import com.domain.TreeNode;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class M114_FlattenBinaryTreeToLinkedList {
    public void flatten1(TreeNode root) {
        while(root != null){
            if(root.left != null){
                // 寻找左子树中最右边的结点
                TreeNode cur = root.left;
                while(cur.right != null){
                    cur = cur.right;
                }
                // 将原来的右子树接到左子树的最右边
                cur.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
            }
            //考虑下一个结点
            root = root.right;
        }
    }


    private TreeNode pre = null;
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
















