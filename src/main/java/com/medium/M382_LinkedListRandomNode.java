package com.medium;

import com.domain.ListNode;

import java.util.Random;

public class M382_LinkedListRandomNode {
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution1 {

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    ListNode list;
    public Solution1(ListNode head) {
        this.list = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        Random random = new Random();
        int res = 0;
        int i = 0;
        ListNode p = list;
        while(p != null){
            if(random.nextInt(++i) == 0){
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */