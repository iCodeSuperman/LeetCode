package com.arithmetic;

import com.domain.TreeNode;
import com.tool.CreateTreeByLayerOrder;
import org.junit.Test;

import java.util.*;

public class BinaryTreePreOrder {
    //二叉树先序非递归遍历
    public void preOrderNonRecursion(TreeNode head){
        Deque<TreeNode> st = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        if(head != null){
            st.addLast(head); //头结点入栈
            while(!st.isEmpty()){
                TreeNode cur = st.removeLast();
                res.add(cur.val);
                if(cur.right != null)
                    st.addLast(cur.right); //右孩子先入栈
                if(cur.left != null)
                    st.addLast(cur.left);
            }
        }
        System.out.println(res);
    }

    //二叉树中序非递归遍历
    public void inOrderNonRecursion(TreeNode head){
        Deque<TreeNode> st = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        if(head != null){
            TreeNode p = head;
            while(!st.isEmpty() || p != null){
                while(p != null){
                    st.addLast(p);
                    p = p.left;
                }
                if(!st.isEmpty()){
                    p = st.removeLast();
                    res.add(p.val);
                    p = p.right;
                }
            }
        }

        System.out.println(res);
    }

    //二叉树后序非递归遍历
    public void postOrderNonRecursion(TreeNode head){
        Deque<TreeNode> st = new ArrayDeque<>();
        Deque<TreeNode> st2 = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        if(head != null){
            st.addLast(head);
            while(!st.isEmpty()){
                TreeNode cur = st.removeLast();
                st2.addLast(cur);
                if(cur.left != null){
                    st.addLast(cur.left);
                }
                if(cur.right != null){
                    st.addLast(cur.right);
                }
            }

            while(!st2.isEmpty()){
                TreeNode cur = st2.removeLast();
                res.add(cur.val);
            }
        }

        System.out.println(res);
    }

    // 后续遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> toVisit = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null || !toVisit.isEmpty()) {
            while (cur != null) {
                toVisit.push(cur); // 添加根节点
                cur = cur.left; // 递归添加左节点
            }
            cur = toVisit.peek(); // 已经访问到最左的节点了
            // 在不存在右节点或者右节点已经访问过的情况下，访问根节点
            if (cur.right == null || cur.right == pre) {
                toVisit.pop();
                result.add(cur.val);
                pre = cur;
                cur = null;
            } else {
                cur = cur.right; // 右节点还没有访问过就先访问右节点
            }
        }
        return result;
    }



    public void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    @Test
    public void t(){
        String[] arr = {"1", "2", "3", "4", "5", "null", "null"};
        TreeNode h = new TreeNode();
        h = CreateTreeByLayerOrder.LayerInsert(h, arr);
        //postOrderNonRecursion(h);
        List<Integer> list = postorderTraversal(h);
        System.out.println(list);
    }
}
