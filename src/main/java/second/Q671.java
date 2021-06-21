package second;

import com.domain.TreeNode;

/**
 * 二叉树中第2小的元素
 */
public class Q671 {
    //1.没有必要记录最小的值，因为最小的一定是根结点。
    // 2.递归找到比根结点大的值时可以立即返回，
    // 不用再遍历当前节点下面的子节点，因为子节点的值不可能比它小。

    public int findSecondMinimumValue(TreeNode root) {
        return order(root, root.val);
    }

    public int order(TreeNode root, int val){
        if(root == null){
            return -1;
        }
        if(root.val > val){
            return root.val;
        }
        int left = order(root.left, val);
        int right = order(root.right, val);
        if(left < 0){
            return right;
        }
        if(right < 0){
            return left;
        }
        return left < right ? left : right;
    }
}
