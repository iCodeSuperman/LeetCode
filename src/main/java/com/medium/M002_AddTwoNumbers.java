package com.medium;

import com.domain.ListNode;


public class M002_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0, sum; // 进位
        ListNode head = new ListNode(-1);
        ListNode p = head;

        while(l1 != null || l2 != null){
            //取出l1, l2的值
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            sum = a + b + c;

            if(sum >= 10){
                c = sum / 10;
                sum = sum % 10;
            }else{
                c = 0;
            }

            ListNode node = new ListNode(sum);
            p.next = node;
            p = node;

            //迭代
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if(c > 0){
            p.next = new ListNode(c);
        }

        return head.next;
    }
}
