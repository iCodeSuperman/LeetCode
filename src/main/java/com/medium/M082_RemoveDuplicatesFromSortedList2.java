package com.medium;

import com.domain.ListNode;
import org.junit.Test;

public class M082_RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p = dummy;
        ListNode q = head;
        ListNode r = q.next;

        while(r != null){
            if(q.val == r.val){
                while(r != null && q.val == r.val){
                    r = r.next;
                }
                q = r;
                p.next = q;
                if(r == null){
                    return dummy.next;
                }
            }else{
                p = q;
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
        int[] arr = {1, 1, 1, 2, 3, 4, 4, 4, 4, 5, 5};
        int i = 0;
        while(i < arr.length){
            ListNode node = new ListNode(arr[i]);
            list.next = node;
            list = list.next;
            i++;
        }

        ListNode res = deleteDuplicates(head.next);
        while(res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
        System.out.println();
    }
}
