package second;

import com.domain.TreeNode;

import java.util.*;

/**
 * 034 二叉树中和为某一值的路径
 * @author icodeboy
 */
public class Offer034 {
    List<List<Integer>> res;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new LinkedList<>();
        this.target = target;
        if(root == null) return res;
        Deque<Integer> path = new ArrayDeque<>();
        dfs(root, 0, path);
        return res;
    }

    public void dfs(TreeNode root, int sum, Deque<Integer> path){
        if(root.left == null && root.right == null){
            if(sum + root.val == target){
                path.addLast(root.val);
                res.add(new ArrayList<>(path));
                path.removeLast();
            }
            return;
        }

        path.addLast(root.val);
        if(root.left != null)
            dfs(root.left, sum + root.val, path);

        if(root.right != null)
            dfs(root.right, sum + root.val, path);
        path.removeLast();
    }
}
