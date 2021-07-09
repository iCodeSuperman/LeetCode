package second;

import com.domain.TreeNode;

public class Q543 {
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(left + right, max);
        return Math.max(left, right) + 1;
    }
}
