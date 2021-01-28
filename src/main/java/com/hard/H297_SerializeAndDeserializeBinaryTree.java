package com.hard;

import com.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class H297_SerializeAndDeserializeBinaryTree {

    String sep = ",";
    String Null = "#";
    Deque<String> list;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        traverse(root, sb);
        return sb.toString();
    }

    public void traverse(TreeNode root, StringBuffer sb){
        if(root == null){
            sb.append(Null).append(sep);
            return;
        }
        sb.append(root.val).append(sep);
        traverse(root.left, sb);
        traverse(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        list = new ArrayDeque<>();
        String[] arr = data.split(sep);
        for (String s : arr) {
            list.addLast(s);
        }
        return rebuild(list);
    }

    public TreeNode rebuild(Deque<String> list){
        if(list.isEmpty()) return null;
        String val = list.removeFirst();
        if(val.equals(Null)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = rebuild(list);
        root.right = rebuild(list);
        return root;
    }
}
