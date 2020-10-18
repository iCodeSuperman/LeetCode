package com.medium;

import com.domain.ListNode;
import org.junit.Test;

public class M086_PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode p = dummy.next;
        while(p != null && p.val < x){
            pre = p;
            p = p.next;
        }
        if(p == null) return head;

        ListNode q = p;
        ListNode r = p.next;
        while(r != null){
            if(r.val < x){
                q.next = r.next;
                r.next = pre.next;
                pre.next = r;
                pre = r;
                r = q;
            }else{
                q = r;
            }
            r = r.next;
        }

        return dummy.next;
    }

    @Test
    public void t(){
        ListNode list = new ListNode(-1);
        ListNode head = list;
        int[] arr = {1, 1};
        int i = 0;
        while(i < arr.length){
            ListNode node = new ListNode(arr[i]);
            list.next = node;
            list = list.next;
            i++;
        }

        ListNode res = partition(head.next, 3);
        while(res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
        System.out.println();
    }
}
