package second;

import com.domain.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 199. 二叉树的右视图
 */
public class Q199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> st = new ArrayDeque<>();
        st.addLast(root);
        while(!st.isEmpty()){
            res.add(st.getLast().val);
            int size = st.size();
            for (int i = 0; i < size; i++) {
                TreeNode now = st.removeFirst();
                if(now.left != null){
                    st.addLast(now.left);
                }
                if(now.right != null){
                    st.addLast(now.right);
                }
            }
        }
        return res;
    }


    @Test
    public void t(){
        ThreadLocal tl = new ThreadLocal();
    }
}
