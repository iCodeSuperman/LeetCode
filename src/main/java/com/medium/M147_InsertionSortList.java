package com.medium;

import com.domain.ListNode;
import org.junit.Test;

public class M147_InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode old = head.next;
        ListNode dummy = new ListNode(-1); // 前导结点
        dummy.next = head;
        head.next = null;

        ListNode pre = dummy; //新链表的前驱
        ListNode cur = dummy.next; //新链表的当前

        while(old != null){
            ListNode temp = old;
            old = old.next;

            if(temp.val < cur.val){
                pre = dummy;
                cur = dummy.next;
            }

            while(cur != null && cur.val < temp.val){
                pre = cur;
                cur = cur.next;
            }
            temp.next = pre.next;
            pre.next = temp;
            cur = temp;
        }

        return dummy.next;
    }

    @Test
    public void t(){
        int[] arr = {4, 1, 3, 2};

        ListNode head = new ListNode(-1);
        ListNode list = head;
        for(int i = 0; i < arr.length; i++){
            list.next = new ListNode(arr[i]);
            list = list.next;
        }
        head = insertionSortList(head.next);

        ListNode p = head;
        while(p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }
}
