package com.ToOffer;

import com.domain.ListNode;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class Offer24 {
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        return reverse(head);
    }

    public ListNode reverse(ListNode p){
        if(p.next == null){
            return p;
        }
        ListNode head = reverse(p.next);
        p.next.next = p;
        p.next = null;
        return head;
    }
}
