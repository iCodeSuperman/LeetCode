package com.medium;

import com.domain.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class M142_LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;

        do{
            if(fast == null || fast.next == null){
                // 没有环
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }while (fast != slow);

        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
















