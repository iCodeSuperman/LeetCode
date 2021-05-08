package com.ToOffer;

import java.util.HashMap;
import java.util.Map;

public class Offer035 {
    public Node copyRandomList2(Node head) {
        if(head == null) return null;
        Node cur = head;
        while(cur != null){
            Node tmp = new Node(cur.val);
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
        Node pre = head;
        Node res = head.next;
        while(cur.next != null){
            pre.next = cur.next;
            pre = pre.next;
            cur.next = pre.next;
            cur = cur.next;
        }
        pre.next = null;
        return res;
    }


    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null){
            int value = cur.val;
            Node newNode = new Node(value);
            map.put(cur, newNode);
            cur = cur.next;
        }

        cur = head;
        while(cur != null){
            Node newCur = map.get(cur);
            newCur.next = map.get(cur.next);
            newCur.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

