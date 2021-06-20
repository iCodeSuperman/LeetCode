package second;

import com.domain.TreeNode;

/**
 * 104. 二叉树的最大深度
 */
public class Q104 {
    public int maxDepth(TreeNode root) {
        return inOrder(root);
    }

    public int inOrder(TreeNode root){
        if(root == null){
            return 1;
        }

        int left = inOrder(root.left);
        int right = inOrder(root.right);
        return left > right ? left : right + 1;
    }
}
