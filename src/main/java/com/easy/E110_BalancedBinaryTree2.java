package com.easy;

import com.domain.TreeNode;

// 通过定义一个final类来同时传递两个消息！
// c++可以通过引用+返回值传递两个消息
final class TreeInfo{
    public final int height;
    public final boolean balanced;
    public TreeInfo(int height, boolean balanced){
        this.height = height;
        this.balanced = balanced;
    }
}

public class E110_BalancedBinaryTree2 {
    public boolean isBalanced(TreeNode root) {
        return postOrder(root).balanced;
    }

    public TreeInfo postOrder(TreeNode root){
       if(root == null){
           return new TreeInfo(0, true);
       }

       TreeInfo leftInfo = postOrder(root.left);
       if(!leftInfo.balanced){
          return new TreeInfo(-1, false);
       }

       TreeInfo rightInfo = postOrder(root.right);
       if(!rightInfo.balanced){
           return new TreeInfo(-1, false);
       }

       int Height = Math.max(leftInfo.height, rightInfo.height) + 1;
       if(Math.abs(leftInfo.height - rightInfo.height) < 2){
           return new TreeInfo(Height, true);
       }

       return new TreeInfo(-1, false);
    }

}
