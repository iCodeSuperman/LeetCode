package com.medium;

import com.domain.ListNode;
import com.domain.TreeNode;
import org.junit.Test;

public class M109_ConvertSortedListToBinarySearchTree2 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode pre = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        if(pre != null) pre.next = null;
        TreeNode node = new TreeNode(slow.val);
        if(head == slow) head = null;
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(slow.next);
        return node;
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
