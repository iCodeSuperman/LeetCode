package com.medium;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import com.domain.ListNode;
import com.domain.TreeNode;
import org.junit.Test;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class M109_ConvertSortedListToBinarySearchTree {
    private ListNode head;
    public TreeNode ConvertSortedListToBST(int l, int r){
        if(l > r){
            return null;
        }

        int mid = (l + r) / 2;
        TreeNode left = ConvertSortedListToBST(l, mid - 1);
        TreeNode node = new TreeNode(this.head.val);
        this.head = this.head.next;
        node.left = left;
        node.right = ConvertSortedListToBST(mid + 1, r);
        return node;
    }
    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        ListNode p = head;
        while(p != null){
            p = p.next;
            len++;
        }

        this.head = head;
        return ConvertSortedListToBST(0, len - 1);
    }

    @Test
    public void t(){
        int[] arr = {1, 2, 3, 4, 5};

        ListNode head = new ListNode(-1);
        ListNode list = head;
        for(int i = 0; i < arr.length; i++){
            list.next = new ListNode(arr[i]);
            list = list.next;
        }
        TreeNode tree = sortedListToBST(head.next);
    }
}













