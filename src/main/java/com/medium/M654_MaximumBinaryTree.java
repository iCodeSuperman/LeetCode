package com.medium;


import com.domain.TreeNode;

public class M654_MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int left, int right){
        if(left > right){
            return null;
        }

        int index = -1;
        int max = Integer.MIN_VALUE;
        for(int i = left; i <= right; i++){
            if(max > nums[i]){
                max = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = build(nums, left, index - 1);
        root.right = build(nums, index + 1, right);
        return root;
    }
}
