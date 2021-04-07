package com.ToOffer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * @author icodeboy
 */
public class Offer059 {
}

class MaxQueue {
    Deque<Integer> queue;
    Deque<Integer> maxSt;
    public MaxQueue() {
        queue = new ArrayDeque<>();
        maxSt = new ArrayDeque<>();
    }

    public int max_value() {
        if(!maxSt.isEmpty()){
            return maxSt.getFirst();
        }
        return -1;
    }

    public void push_back(int value) {
        queue.addLast(value);
        if (!maxSt.isEmpty()) {
            while (!maxSt.isEmpty() && value >= maxSt.getLast()) {
                maxSt.removeLast();
            }
        }
        maxSt.addLast(value);
    }

    public int pop_front() {
        if(!queue.isEmpty()){
            int elem = queue.removeFirst();
            if(elem == maxSt.getLast().intValue()){
                maxSt.removeLast();
            }
            return elem;
        }
        return -1;
    }
}
