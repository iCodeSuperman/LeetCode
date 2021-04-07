package com.ToOffer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author icodeboy
 */
public class Offer009 {

}

class CQueue {
    Deque<Integer> st1;
    Deque<Integer> st2;

    public CQueue() {
        st1 = new ArrayDeque<>();
        st2 = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        st1.addLast(value);
    }

    public int deleteHead() {
        if(st1.isEmpty() && st2.isEmpty()){
            return -1;
        }
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.addLast(st1.removeLast());
            }
        }
        return st2.removeLast();
    }
}