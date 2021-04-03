package com.ToOffer;

import com.domain.ListNode;

public class Offer052 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode pa = headA;
        ListNode pb = headB;
        while(pa != pb){
            pa = pa.next;
            pb = pb.next;
            if(pa == null && pb == null) break;
            if(pa == null) pa = headB;
            if(pb == null) pb = headA;
        }
        return pa;
    }
}
