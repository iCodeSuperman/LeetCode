package com.easy;

import com.domain.TreeNode;

//将有序数组转换为二叉搜索树
public class E108_ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return createTree(0, nums.length-1, nums);
    }
    // 默认中间位置左边元素为根节点
    public TreeNode createTree(int left, int right, int[] nums){
        if(left > right){
            //递归终止条件
            return null;
        }
        int mid = (left + right) / 2; //中间位置左边为根; index[0, 1] -> (0+1)/2=0;
        TreeNode bt = new TreeNode(nums[mid]);
        bt.left = createTree(left, mid-1, nums);
        bt.right = createTree(mid+1, right, nums);
        return bt;
    }

}
