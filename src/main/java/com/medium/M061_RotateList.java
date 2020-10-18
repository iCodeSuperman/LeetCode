package com.medium;

import com.domain.ListNode;
import org.junit.Test;

public class M061_RotateList {
    public ListNode rotateRight2(ListNode head, int k) {
        if(head == null) return head;
        ListNode tail = head;
        int len = 1;
        while(tail.next != null){
            tail = tail.next;
            len++;
        }
        if(k > len){
            k = k % len;
        }
        if(k == 0 || k == len){
            return head;
        }


        ListNode p = head;
        ListNode q = head;
        int offset = len - k - 1;
        while(offset > 0){
            q = q.next;
            offset--;
        }

        head = q.next;
        q.next = null;
        tail.next = p;

        return head;
    }

    public ListNode rotateRight(ListNode head, int k){
        if(head == null || head.next == null) return head;

        //将尾结点连到头结点，形成环，并统计链表长度
        ListNode old_tail = head;
        int len = 1;
        while(old_tail.next != null){
            old_tail = old_tail.next;
            len++;
        }
        old_tail.next = head;

        //新尾部结点是下标为(len - k % len - 1)结点 -> 5-2%5-1=1
        //新尾部结点是下标为(len - k % len)结点 -> 5-2%5=2
        ListNode new_tail = head;
        for(int i = 0; i < len - k % len - 1; i++){ //先计算%，后计算-
            new_tail = new_tail.next;
        }

        head = new_tail.next;
        new_tail.next = null;
        return head;
    }

    @Test
    public void t(){
        ListNode list = new ListNode(1);
        ListNode head = list;
        int n = 1;
        while(n < 5){
            ListNode node = new ListNode(++n);
            list.next = node;
            list = node;
        }
        ListNode res = rotateRight(head, 3);
        while(res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
        System.out.println();
    }
}










