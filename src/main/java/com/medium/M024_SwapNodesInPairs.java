package com.medium;

import com.domain.ListNode;
import org.junit.Test;

public class M024_SwapNodesInPairs {
    public ListNode swapPairs2(ListNode head) {
        if(head == null) return null;
        ListNode pre = head;
        ListNode p = pre.next;
        ListNode temp;
        if(p != null){ //单独处理前面一个或两个结点情况
            pre.next = p.next;
            p.next = pre;
            head = p;
            temp = pre;
        }else{
            return head;
        }

        while(temp.next != null){
            pre = temp.next;
            p = pre.next;
            if(p == null) break;
            pre.next = p.next;
            p.next = pre;
            temp.next = p;
            temp = pre;
        }

        return head;
    }
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;

        first.next = swapPairs(second.next);
        second.next = first;

        return second;
    }

    @Test
    public void t(){

    }
}
