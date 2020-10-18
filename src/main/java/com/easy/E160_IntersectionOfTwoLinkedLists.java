package com.easy;

import com.domain.ListNode;

public class E160_IntersectionOfTwoLinkedLists {
    /**
     * 速度一样，路程一样，则同时到终点
     * Da = a + c; Db = b + c;
     * a+c+b+c = b+c+a+c;
     * 若Da和Db相交，则a+c+b和b+c+a会抵消(两人走了同一段路)，会在最后一个c处相遇
     * 若Da和Db不相交，则c为空，即a+b = b+a(各自移动到尾部结束)，返回null
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB){
        if(headA == null || headB == null){
            return null;
        }
        ListNode pa = headA;
        ListNode pb = headB;
        /**
         *  当pa或pb为空时，它们开始指向另一链表的头部，
         *  当链表AB没有公共部分c时，pa和pb同时为空，
         *  每次判断pa或pb是否为空进行赋值的好处是，这样避免了死循环.
         */
        while(pa != pb){
            pa = pa == null ? headA : pa.next; //pa遍历到自己尾部，必定为空，然后下一次切换到pb链表头部
            pb = pb == null ? headB : pb.next;
        }
        return pa;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        int countA = 0 ,countB = 0;
        while(a != null){
            a = a.next;
            countA++;
        }

        while(b != null){
            b = b.next;
            countB++;
        }

        if(countA > countB){
            int delta = countA - countB;
            while(delta > 0){
                headA = headA.next;
                delta--;
            }
            while(headA != null && headB != null){
                if(headA == headB){
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
        }else{
            int delta = countB - countA;
            while(delta > 0){
                headB = headB.next;
                delta--;
            }
            while(headA != null && headB != null){
                if(headA == headB){
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
        }

        return null;
    }
}
