package second;

import com.domain.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. 路径总和 III
 * @author icodeboy
 */
public class Q437 {

    /**
     * 前缀和
     */
    private Map<Integer, Integer> prefixSum;
    private int target;
    public int pathSum(TreeNode root, int targetSum){
        // key=前缀和，value=个数
        prefixSum = new HashMap<>();
        target = targetSum;
        prefixSum.put(0, 1);
        return recur(root, 0);

    }

    public int recur(TreeNode root, int curSum){
        if(root == null){
            return 0;
        }
        curSum += root.val;
        int res = prefixSum.getOrDefault(curSum - target, 0);
        prefixSum.put(curSum, prefixSum.getOrDefault(curSum, 0) + 1);

        int left = recur(root.left, curSum);
        int right = recur(root.right, curSum);

        prefixSum.put(curSum, prefixSum.get(curSum) - 1);
        res = res + left + right;
        return res;
    }



    /**
     * O(n^2)
     */
    private int targetSum;
    private int count;
    public int pathSum2(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        preOrder(root);
        return count;
    }

    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root, 0);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void dfs(TreeNode root, int sum){
        if(root == null){
            return;
        }
        sum += root.val;
        if(sum == targetSum){
            count++;
            // return;
            /**
             * 单左子树 1 -> -2 -> 1 -> -1
             * (1): 1 -2
             * (2): 1 -2 1 -1
             */
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
    }


    public void test(){
        Map<Integer,Integer> hash = new HashMap<>();
    }
}
