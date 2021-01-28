package com.easy;

import com.domain.ListNode;

public class E234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null; //用于恢复链表结构
        ListNode tail = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null){
            prev = slow;
            slow = slow.next;
        }

        ListNode right = reverse(slow);
        ListNode left = head;
        tail = right;
        while(right != null){
            if(right.val != left.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        prev.next = reverse(tail);
        return true;
    }
    public ListNode reverse(ListNode slow){
        ListNode pre = null;
        ListNode cur = slow;
        ListNode nxt = slow;
        while(cur != null){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
