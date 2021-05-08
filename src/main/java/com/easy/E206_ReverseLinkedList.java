package com.easy;


import com.domain.ListNode;

/**
 * @author icodeboy
 */
public class E206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        return reverse(head);
    }
    public ListNode reverse(ListNode head){
        if(head.next == null){
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return head;
    }
}
