package com.ToOffer;

import java.util.HashMap;
import java.util.Map;

public class Offer035 {
    public com.ToOffer.offer036.Node copyRandomList2(com.ToOffer.offer036.Node head) {
        if(head == null) return null;
        com.ToOffer.offer036.Node cur = head;
        while(cur != null){
            com.ToOffer.offer036.Node tmp = new com.ToOffer.offer036.Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }

        cur = head;
        while(cur != null){
            if(cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        cur = head.next;
        com.ToOffer.offer036.Node pre = head;
        com.ToOffer.offer036.Node res = head.next;
        while(cur.next != null){
            pre.next = cur.next;
            pre = pre.next;
            cur.next = pre.next;
            cur = cur.next;
        }
        pre.next = null;
        return res;
    }


    public com.ToOffer.offer036.Node copyRandomList(com.ToOffer.offer036.Node head) {
        Map<com.ToOffer.offer036.Node, com.ToOffer.offer036.Node> map = new HashMap<>();
        com.ToOffer.offer036.Node cur = head;
        while(cur != null){
            int value = cur.val;
            com.ToOffer.offer036.Node newNode = new com.ToOffer.offer036.Node(value);
            map.put(cur, newNode);
            cur = cur.next;
        }

        cur = head;
        while(cur != null){
            com.ToOffer.offer036.Node newCur = map.get(cur);
            newCur.next = map.get(cur.next);
            newCur.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}

class Node {
    int val;
    com.ToOffer.offer036.Node next;
    com.ToOffer.offer036.Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

