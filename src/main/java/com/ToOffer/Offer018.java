package com.ToOffer;

import com.domain.ListNode;

public class Offer018 {
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null) return null;
        if(head.val == val) return head.next;

        ListNode p = head;
        ListNode q = head.next;
        while(q != null && q.val != val){
            q = q.next;
            p = p.next;
        }
        if(q != null){
            p.next = q.next;
        }else{
            p.next = null;
        }
        return head;

    }
}
