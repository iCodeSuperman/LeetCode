package com.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class E155_MinStack {
    /** initialize your data structure here. */
    private List<Integer> arr = new ArrayList<Integer>();
    private int top = -1;
    public E155_MinStack() {

    }

    public void push(int x) {
        arr.add(x);
        top++;
    }

    public void pop() {
        if(top >= 0){
            arr.remove(top);
            top--;
        }
    }

    public int top() {
        if(top >= 0){
            return arr.get(top);
        }
        return -1;
    }

    public int getMin() {
        return Collections.min(arr);
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */