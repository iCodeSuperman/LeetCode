package com.easy;

import com.domain.ListNode;

public class E203_RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        while(head != null && head.val == val){
            head = head.next;
        }
        ListNode pre = head;
        ListNode p = pre;
        if(pre != null) p = pre.next;
        while(p != null){
            while(p != null && p.val == val){
                p = p.next;
            }
            pre.next = p;
            pre = p;
            if(p != null){
                p = p.next;
            }
        }
        return head;
    }
}
