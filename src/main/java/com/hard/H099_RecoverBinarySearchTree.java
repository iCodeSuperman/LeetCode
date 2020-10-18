package com.hard;

import com.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class H099_RecoverBinarySearchTree {

    public void recoverTree3(TreeNode root){
        TreeNode predecessor = null;
        TreeNode pred = null;
        TreeNode[] v = new TreeNode[2];
        while(root != null){
            if(root.left != null){
                // 找root.left中最右的孩子
                predecessor = root.left;
                while(predecessor.right != null && predecessor.right != root){
                    predecessor = predecessor.right;
                }

                if(predecessor.right == null){
                    predecessor.right = root;
                    root = root.left;
                }else{
                    if(pred != null && pred.val > root.val){
                        v[1] = root;
                        if(v[0] == null){
                            v[0] = pred;
                        }
                    }
                    pred = root;

                    predecessor.right = null;
                    root = root.right;
                }
            }else{
                if(pred != null && pred.val > root.val){
                    v[1] = root;
                    if(v[0] == null){
                        v[0] = pred;
                    }
                }
                pred = root;
                root = root.right;
            }
        }

        int temp = v[0].val;
        v[0].val = v[1].val;
        v[1].val = temp;

    }



    public void recoverTree2(TreeNode root){
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode p = root;
        TreeNode pre = null; //pre node
        TreeNode [] ts = new TreeNode[2];
        while(!st.isEmpty() || p != null){
            while(p != null){
                st.addLast(p);
                p = p.left;
            }
            p = st.removeLast();
            if(pre != null && pre.val > p.val){
                ts[1] = p;
                if(ts[0] == null){
                    ts[0] = pre;
                }else{
                    break;
                }
            }
            pre = p;
            p = p.right;
        }

        int temp = ts[0].val;
        ts[0].val = ts[1].val;
        ts[1].val = temp;
    }

    private List<Integer> lists = new ArrayList<>();
    int x = 0;
    int y = 0;

    public void recoverTree(TreeNode root) {
        inOrder(root);
        int flag = 0;
        for(int i = 0; i < lists.size() - 1; i++){
            if(lists.get(i) < lists.get(i + 1)){
                if(flag == 0){
                    x = lists.get(i);
                    flag = 1;
                }else{
                    y = lists.get(i + 1);
                    flag = 2;
                }
            }
        }
        replaceInOrder(root);
    }

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        lists.add(root.val);
        inOrder(root.right);
    }

    public void replaceInOrder(TreeNode root){
        if(root == null){
            return;
        }
        replaceInOrder(root.left);
        if(root.val == x){
            root.val = y;
        }else if(root.val == y){
            root.val = x;
        }
        replaceInOrder(root.right);
    }
}
