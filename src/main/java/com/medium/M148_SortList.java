package com.medium;

import com.domain.ListNode;
import org.junit.Test;

public class M148_SortList {
    public ListNode sortList(ListNode head) {
        // 特判
        if(head == null || head.next == null){
            return head;
        }
        ListNode h = head;
        int len = 0;
        int intv = 1;
        // 预处理-求出链表总长度len，用于和intv比较
        while(h != null){
            h = h.next;
            len++;
        }

        // 设定整个链表的前驱哑结点，作为后面每一轮比较的起点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre, h1, h2;
        while(intv < len){
            pre = dummy; //每一轮开始，都将pre指向链表的哑巴结点，同时不断后移
            h = pre.next; //每一轮开始，都将h指向链表的第一个结点，同时不断后移
            while(h != null){
                h1 = h;
                // 找h2
                int i = 0;
                for(; i < intv; i++){ //这里h在h1为头结点的左链表移动
                    if(h == null) break;
                    h = h.next;
                }
                // 寻找h2的时候，当后面剩余结点个数不足intv时，将剩余结点放到下一轮合并
                // 即剩余结点只能满足h1为头结点的左链表，h2头结点的右链表一个结点都不够
                if(i < intv) break;
                h2 = h;

                // 寻找下一个区间的h1，并记为h
                // 这里i开始计数区间2的结点个数
                for (i = 0; i < intv; i++) { //这里h在h2为头结点的右链表移动
                    if (h == null) break;
                    h = h.next;
                }

                // 合并
                int len1 = intv;
                int len2 = i;
                while(len1 > 0 && len2 > 0){
                    if(h1.val < h2.val){
                        pre.next = h1;
                        h1 = h1.next;
                        len1--;
                    }else {
                        pre.next = h2;
                        h2 = h2.next;
                        len2--;
                    }
                    pre = pre.next;
                }

                while(len1 > 0){
                    pre.next = h1;
                    h1 = h1.next;
                    len1--;
                    pre = pre.next;
                }

                while(len2 > 0){
                    pre.next = h2;
                    h2 =h2.next;
                    len2--;
                    pre = pre.next;
                }
                // 将这个区间的尾部结点作为pre,并与h指向的下一个区间联系起来，不至于断链
                pre.next = h;
            }
            intv = intv * 2;

        }
        return dummy.next;
    }

    @Test
    public void t(){
        int[] arr = {4, 1, 3, 2, 0};

        ListNode head = new ListNode(-1);
        ListNode list = head;
        for(int i = 0; i < arr.length; i++){
            list.next = new ListNode(arr[i]);
            list = list.next;
        }
        head = sortList(head.next);

        ListNode p = head;
        while(p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }
}












