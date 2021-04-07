package com.ToOffer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author icodeboy
 */
public class Offer030 {
}


class MinStack {

    /** initialize your data structure here. */
    Deque<Integer> dataSt;
    Deque<Integer> minSt;
    public MinStack() {
        dataSt = new ArrayDeque<>();
        minSt = new ArrayDeque<>();
    }

    public void push(int x) {
        dataSt.addLast(x);
        if(minSt.isEmpty() || x < minSt.getLast()){
            minSt.addLast(x);
        }
    }

    public void pop() {
        if(!dataSt.isEmpty()){
            int data = dataSt.removeLast();
            if(data == minSt.getLast().intValue()){
                minSt.removeLast();
            }
        }
    }

    public int top() {
        return dataSt.getLast();
    }

    public int min() {
        return minSt.getLast();
    }
}


