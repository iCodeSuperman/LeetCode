package second;

import com.domain.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 打家劫舍3
 */
public class Q377 {
    private Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root)  {
        return robRange(root);
    }

    public int robRange(TreeNode root){
        if(root == null){
            return 0;
        }
        if(memo.containsKey(root)){
            return memo.get(root);
        }
        int method1 = root.val;
        if(root.left != null){
            method1 += robRange(root.left.left) + robRange(root.left.right);
        }
        if(root.right != null){
            method1 += robRange(root.right.left) + robRange(root.right.right);
        }

        int method2 = robRange(root.left) + robRange(root.right);

        int max = Math.max(method1, method2);
        memo.put(root, max);
        return max;
    }
}
