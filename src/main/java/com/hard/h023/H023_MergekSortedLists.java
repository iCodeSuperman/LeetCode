package com.hard.h023;

public class H023_MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        int len = lists.length;

        while(len > 1){
            for(int i = 0; i < len; i += 2){
                if(i + 1 >= len){
                    lists[i / 2] = lists[i];
                }
                lists[i / 2] = merge(lists[i], lists[i + 1]);
            }

            if(len % 2 == 0){
                len = len / 2;
            }else{
                len = len / 2 + 1;
            }

        }

        return lists[0];
    }

    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                p.next = head1;
                head1 = head1.next;
            }else{
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }

        if(head1 != null){
            p.next = head1;
        }
        if(head2 != null){
            p.next = head2;
        }

        return dummy.next;
    }
}




