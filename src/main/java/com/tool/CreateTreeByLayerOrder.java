package com.tool;

import com.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CreateTreeByLayerOrder {

    public static TreeNode LayerInsert(TreeNode root, String arr[]){
        if(arr.length == 0){
            System.out.println("空数组");
            return root;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        root = new TreeNode(str2num(arr[0]));
        q.offer(root);
        int i = 1;
        while(i < arr.length){
            TreeNode now = q.poll();
            if(now.left == null){
                if(i < arr.length && str2num(arr[i]) > Integer.MIN_VALUE){
                    now.left = new TreeNode(str2num(arr[i]));
                    q.offer(now.left);
                }

                i++;
            }

            if(now.right == null){
                if(i < arr.length && str2num(arr[i]) > Integer.MIN_VALUE){
                    now.right = new TreeNode(str2num(arr[i])) ;
                    q.offer(now.right);
                }

                i++;
            }
        }

        return root;
    }

    public static int str2num(String s){
        if(s == "null"){
            return Integer.MIN_VALUE;
        }else{
            return Integer.parseInt(s);
        }
    }


}
