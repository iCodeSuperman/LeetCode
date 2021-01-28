package com.medium;

import com.domain.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class M652_FindDuplicateSubtrees {

    List<TreeNode> res = new LinkedList<>();
    Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    public String traverse(TreeNode root){
        if(root == null){
            return "#";
        }
        StringBuffer left = new StringBuffer(traverse(root.left));
        StringBuffer right = new StringBuffer(traverse(root.right));
        StringBuffer rootValue = new StringBuffer();
        rootValue.append(left).append(",").append(right).append(",").append(root.val);

        int count = map.getOrDefault(rootValue.toString(), 0);
        if(count == 1){
            res.add(root);
        }
        map.put(rootValue.toString(), count + 1);
        return rootValue.toString();
    }
}
