package com.easy;

import com.domain.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class E021_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode list = new ListNode(-1);
        ListNode pre = list;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if(l1 != null){
            pre.next = l1;
        }else{
            pre.next = l2;
        }
        return list.next;
    }
}













