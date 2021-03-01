package com.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class E232_ImplementQueueUsingStacks {
    /**
     * 用两个栈实现队列
     */
}
class MyQueue {

    Deque<Integer> s1;
    Deque<Integer> s2;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.addLast(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return s2.removeLast();
    }

    /** Get the front element. */
    public int peek() {
        //s2不为空，将s1的元素移入s2
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.addLast(s1.removeLast());
            }
        }
        return s2.getLast();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}