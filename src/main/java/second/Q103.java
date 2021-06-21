package second;

import com.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层序遍历
 */
public class Q103 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        boolean flag = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            //List<Integer> list = new ArrayList<>(size);
            Deque<Integer> tmp = new ArrayDeque<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode now = queue.removeFirst();
                //list.add(now.val);
                if(flag){
                    tmp.addLast(now.val);
                    //flag = false;
                }else{
                    tmp.addFirst(now.val);
                    //flag = true;
                }

                if(now.left != null){
                    queue.addLast(now.left);
                }
                if(now.right != null){
                    queue.addLast(now.right);
                }
            }
            flag = flag == true ? false : true;
            res.add(new ArrayList<>(tmp));
        }
        return res;
    }
}
