package com.medium;

import com.domain.ListNode;
import org.junit.Test;

public class M0143_ReorderList {
    ListNode r;
    public void reorderList(ListNode head) {
        if(head == null) return;
        int len = 0;
        ListNode p = head;
        while(p != null){ //统计链表长度，方便截取
            p = p.next;
            len++;
        }

        int pos = len / 2;
        p = head;
        while(pos > 0){
            p = p.next;
            pos--;
        }
        //len=奇数:1->2->3->4->5 变:p=1->2->3 r=4->5
        //len=偶数:1->2->3->4    变:p=1->2->3 r=4

        ListNode tail = p;  // (len==偶数)标记回溯的结束标记，即下一个为尾部结点，结束回溯
        r = p.next;
        p.next = null;
        p = head;

        if(len % 2 == 0){
            callback(p, tail);
        }
        else{
            callback(p, null);
        }
    }

    public void callback(ListNode p, ListNode tail){
        if(p.next == tail){
            return;
        }
        callback(p.next, tail);
        ListNode temp = null;
        if(r == null) return;
        temp = r;
        r = r.next;
        temp.next = p.next;
        p.next = temp;

    }

    @Test
    public void t(){
        ListNode head = new ListNode(-1);
        ListNode list = head;
        for(int i = 1; i <= 5; i++){
            list.next = new ListNode(i);
            list = list.next;
        }
        reorderList(head.next);

        ListNode p = head.next;
        while(p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }
}
