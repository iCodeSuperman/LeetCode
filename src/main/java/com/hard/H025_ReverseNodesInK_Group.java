package com.hard;

import com.domain.ListNode;

public class H025_ReverseNodesInK_Group {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode a, b;
        a = head;
        b = head;
        for(int i = 0; i < k; i++){
            if(b == null) return head;
            b = b.next;
        }
        ListNode newHead = reverseAB(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    public ListNode reverseAB(ListNode a, ListNode b){
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a;
        while(cur != b){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    public ListNode reverseKGroup2(ListNode head, int k){
        if(head == null || head.next == null){
            return head;
        }

        ListNode conn = null; //区间前驱
        //ListNode tail = null; //区间尾巴
        ListNode start = head; //区间第一个
        ListNode end = head; //区间下一个

        ListNode prev = null;
        ListNode cur = head;
        ListNode nxt = head;
        int count = k;

        while(true){
            while(count > 0 && end != null){
                end = end.next;
                count--;
            }
            if(count != 0 && end == null){
                break;
            }else{
                count = k;
            }
            //tail = start;
            while(cur != end){
                nxt = cur.next;
                cur.next = prev;
                prev = cur;
                cur = nxt;
            }

            //tail.next = cur;
            start.next = cur;
            if(conn == null){
                head = prev;
                //conn = tail;
                conn = start;
            }else{
                conn.next = prev;
                //conn = tail;
                conn = start;
            }

            start = end;
            //tail = start;
        }
        return head;
    }
}
