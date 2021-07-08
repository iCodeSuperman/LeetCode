package second;


import com.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * @author icodeboy
 */
public class Q257 {
    private List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        if(root == null){
            return res;
        }
        dfs(root, "");
        return res;
    }

    public void dfs(TreeNode root, String path){
        if(root.left == null && root.right == null){
            path = path + root.val;
            res.add(path);
            return;
        }
        path = path + root.val;
        if(root.left != null){
            dfs(root.left, path + "->");
        }
        if(root.right != null){
            dfs(root.right, path + "->");
        }
    }
}
