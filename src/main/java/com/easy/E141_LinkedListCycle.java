package com.easy;

import com.domain.ListNode;

import java.util.HashSet;

public class E141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
    public boolean hasCycle2(ListNode head) {
        HashSet<ListNode> st = new HashSet<ListNode>();
        while(head != null){
            if(st.contains(head)){
                return false;
            }
            st.add(head);
            head = head.next;
        }
        return true;
    }
}
