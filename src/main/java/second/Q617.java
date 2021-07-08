package second;

import com.domain.TreeNode;

/**
 * 617. 合并二叉树
 * @author icodeboy
 */
public class Q617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1, root2);
    }

    public TreeNode merge(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return null;
        }

        int v1 = root1 == null ? 0 : root1.val;
        int v2 = root2 == null ? 0 : root2.val;

        TreeNode newNode = new TreeNode(v1 + v2);
        newNode.left = merge(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        newNode.right = merge(root1 == null ? null : root1.right, root2 == null ? null : root2.right);

        return newNode;
    }
}
