package com.medium;

import com.domain.ListNode;

public class M092_ReverseLinkedList2 {
    private ListNode left;
    private boolean isStop;
    public ListNode reverseBetween(ListNode head, int m, int n) {
        this.left = head;
        this.isStop = false;
        recurseAndReverse(head, m, n);
        return head;
    }
    public void recurseAndReverse(ListNode right, int m, int n) {
        // 终止条件
        if(n == 1){
            return;
        }
        right = right.next;

        // 左指针移动到左边指定位置(全局一共移动m-1次)
        if(m > 1){
            this.left = this.left.next;
        }

        recurseAndReverse(right, m - 1, n - 1);

        //条件1：奇数个，在中间结点相遇；条件2：偶数个，中间对峙（无条件2会穿过）
        if(this.left == right || right.next == this.left){
            this.isStop = true;
        }

        if(!this.isStop){
            int temp = this.left.val;
            this.left.val = right.val;
            right.val = temp;

            this.left = this.left.next;
        }
    }   

    public ListNode reverseBetween2(ListNode head, int m, int n){
        if(head == null || head.next == null) return head;

        ListNode cur = head, pre = null;
        while(m > 1){
            pre = cur;
            cur = cur.next;
            m--;
            n--;
        }

        ListNode con = pre, tail = cur;
        ListNode temp = null;
        while(n > 0){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            n--;
        }

        if(con != null){
            con.next = pre;
        }else{
            head = pre;
        }
        tail.next = cur;

        return head;
    }

    public ListNode reverseBetween3(ListNode head, int m, int n){
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = null;
        ListNode start = head;
        ListNode tail = head;
        while(m > 1 && start != null){
            p = start;
            start = start.next;
            m--;
        }
        while(n > 0 && tail != null){
            tail = tail.next;
            n--;
        }

        ListNode q = start;

        ListNode prev, cur, nxt;
        prev = null; cur = start; nxt = start;
        while(cur != tail){
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }

        q.next = cur;
        if(p == null){
            return prev;
        }
        p.next = prev;

        return head;
    }
}














