package com.medium;

import com.domain.MyNode;
import org.junit.Test;

public class M138_CopyListWithRandomPointer {
    public MyNode copyRandomList2(MyNode head) {
        if(head == null) return null;
        MyNode[] myList = new MyNode[20010]; //mid 0 - 10000

        MyNode p = head;
        while(p != null){
            int index = p.val + 10000;
            myList[index] = new MyNode(p.val);
            p = p.next;
        }

        p = head;
        while(p != null){
            int val_index = p.val + 10000; //根据值确定结点坐标

            if(p.next != null){
                int next_index = p.next.val + 10000; //根据next结点的值确定坐标
                myList[val_index].next = myList[next_index];
            }else{
                myList[val_index].next = null;
            }

            if(p.random == null){
                myList[val_index].random = null;
            }else{
                int ran_index = p.random.val + 10000;
                myList[val_index].random = myList[ran_index];
            }
            p = p.next;
        }

        return myList[head.val+10000];
    }

    public MyNode copyRandomList(MyNode head){
        if(head == null){
            return null;
        }
        MyNode pre = head;
        while(pre != null){
            MyNode temp = new MyNode(pre.val);
            temp.next = pre.next;
            pre.next = temp;
            pre = temp.next;
        }

        pre = head;
        MyNode p;
        while(pre != null){
            p = pre.next;
            p.random = pre.random == null ? null : pre.random.next;
            pre = p.next;
        }

        pre = head;
        MyNode newHead = head.next;
        while(pre != null){
            p = pre.next;
            pre.next = p.next;
            pre = pre.next;
            p.next = pre == null ? null : pre.next;
        }
        return newHead;
    }

    @Test
    public void t(){
        MyNode n1 = new MyNode(1);
        MyNode n2 = new MyNode(2);
        MyNode n3 = new MyNode(3);
        MyNode n4 = new MyNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;

        n1.random = null;
        n2.random = n3;
        n3.random = n2;
        n4.random = n3;

        MyNode node = copyRandomList(n1);
        //MyNode node = n1;
        while (node != null){
            int val = node.val;
            String ran;
            if(node.random == null){
                 ran = "null";
            }else{
                 ran = node.random.val + "";
            }
            System.out.println("[" +val + ", " + ran + "]");
            node = node.next;
        }
    }
}
