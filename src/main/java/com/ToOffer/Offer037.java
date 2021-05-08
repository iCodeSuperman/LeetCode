package com.ToOffer;

import com.sun.xml.internal.xsom.XSUnionSimpleType;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class Offer037 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "[]";
        }
        StringBuffer sb = new StringBuffer("[");
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);

        while(!deque.isEmpty()){


            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.removeFirst();
                if(cur != null){
                    sb.append(cur.val).append(",");
                    deque.addLast(cur.left);
                    deque.addLast(cur.right);
                }else {
                    sb.append("null").append(",");
                }
            }

        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(Objects.equals(data, "[]")){
            return null;
        }
        data = data.substring(1, data.length() - 1);
        String[] strs = data.split(",");

        TreeNode root = null;
        if(Objects.equals(strs[0], "null")){
            return root;
        }else{
            int value = Integer.parseInt(strs[0]);
            root = new TreeNode(value);
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);

        int i = 1;
        while(i < strs.length){
            TreeNode cur = deque.removeFirst();
            if(Objects.equals(strs[i], "null")){
                cur.left = null;
            }else{
                cur.left = new TreeNode(Integer.parseInt(strs[i]));
                deque.addLast(cur.left);
            }
            i++;

            if(Objects.equals(strs[i], "null")){
                cur.right = null;
            }else{
                cur.right = new TreeNode(Integer.parseInt(strs[i]));
                deque.addLast(cur.right);
            }
            i++;
        }
        return root;
    }


    @Test
    public void t(){
        String data = "[1,2]";
        TreeNode root = this.deserialize(data);
        String s = this.serialize(root);
        System.out.println(s);
        System.out.println(Objects.equals(data, s));
    }

    @Test
    public void t2(){
        Deque<TreeNode> dq = new LinkedList<>();
        dq.addLast(null);
        System.out.println(dq.getLast() == null);
    }
}
