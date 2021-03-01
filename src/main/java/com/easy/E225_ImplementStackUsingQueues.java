package com.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class E225_ImplementStackUsingQueues {
    /**
     * 用队列实现栈
     *
     * 注意队尾进元素，队头出元素；所以实现栈，则只能队尾进队尾出。
     * 但是队列api不允许队尾出，所以转换为n-1个元素从队头出然后队尾再进，
     * 只留下第n个元素，从队头出，从而实现pop()
     */
}
class MyStack {

    Deque<Integer> queue;
    Integer endElement;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.addLast(x);
        endElement = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = queue.size();
        //将n-2个元素从队头取出，放入队尾
        // 1 2 3 4 -> 3 4 1 2
        while(size > 2){
            queue.addLast(queue.removeFirst());
        }
        //更新队尾元素 4 -> 3
        endElement = queue.getFirst();
        queue.addLast(queue.removeFirst());
        return queue.removeFirst();
    }

    /** Get the top element. */
    public int top() {
        return endElement;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
