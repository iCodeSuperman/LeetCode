package interview;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * @author icodeboy
 * 110. 平衡二叉树
 */
public class Q001 {

    @Test
    public void t() {
        String[] arr = {"3", "9", "20", "null", "null", "15", "7"};
        String[] arr2 = {"1","2","2","3","3","null","null","4","4"};
        TreeNode root = buildTree(arr);
        //inOrder(root);
        System.out.println(isBalanced(null));
    }

    private boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        dfs(root);
        return flag;
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        if(Math.abs(left - right) > 1){
            flag = false;
        }
        return Math.max(left, right) + 1;
    }

    public TreeNode buildTree(String[] arr){
        if(Objects.equals(arr[0], "null")){
            return null;
        }
        int count = 0;
        TreeNode root = new TreeNode(Integer.parseInt(arr[count]));
        count++;

        Deque<TreeNode> st = new ArrayDeque<>();
        st.addLast(root);

        while(!st.isEmpty() && count < arr.length){
            int size = st.size();
            TreeNode now = st.removeFirst();

            if(!Objects.equals(arr[count], "null")){
                now.left = new TreeNode(Integer.parseInt(arr[count]));
            }else {
                now.left = null;
            }
            count++;
            if(now.left != null){
                st.addLast(now.left);
            }


            if(!Objects.equals(arr[count], "null")){
                now.right = new TreeNode(Integer.parseInt(arr[count]));
            }else {
                now.right = null;
            }
            count++;
            if(now.right != null){
                st.addLast(now.right);
            }


        }


        return root;
    }

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

}


class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}