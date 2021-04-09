package se.review;

import com.domain.ListNode;

public class Q092_ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        while(m > 1){
            prev = prev.next;
            m--;
            n--;
        }

        ListNode cur = prev.next;
        ListNode start = prev;
        ListNode tail = cur;
        ListNode third = null;

        while(n > 0){
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n --;
        }

        if(start == dummy){
            head = prev;
        }else{
            start.next = prev;
        }
        tail.next = cur;

        return head;
    }
}
