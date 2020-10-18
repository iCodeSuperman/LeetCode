package com.medium;

import com.domain.ListNode;

public class M019_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head; // 前一个指针
        ListNode p = pre.next;
        ListNode tail = p; //第一个抵达尾部的指针
        int i = n - 1;
        while(i > 0 && tail.next != null){
            tail = tail.next; //移动到距离p相差n的位置
            i--;
        }
        if(tail.next == null) return p;

        while(tail.next != null){
            tail = tail.next;
            pre = p;
            p = p.next;
        }
        if(p == null){
            return head;
        }else{
            pre.next = p.next;
        }

        return head;
    }
}
