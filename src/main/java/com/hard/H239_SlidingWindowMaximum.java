package com.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class H239_SlidingWindowMaximum {
    List<Integer> res = new ArrayList<>();
    MonotonicQueue mq = new MonotonicQueue();
    public int[] maxSlidingWindow(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++){
            if(i < k - 1){
                mq.push(nums[i]);
            }else{
                // 注意此时滑动窗口中只有2个元素
                mq.push(nums[i]);
                // 3个元素
                res.add(mq.getMax());
                mq.pop(nums[i - k + 1]); //2-3+1 = 0
                // 2个元素
            }
        }
        int[] arr = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            arr[i] = res.get(i);
        }
        return arr;
    }

    private class MonotonicQueue{

        LinkedList<Integer> list = new LinkedList<>();

        // 插入数据
        public void push(int n){
            // 从队列尾部开始删除比n小的元素
            while(!list.isEmpty() && list.getLast() < n){
                list.removeLast();
            }
            list.addLast(n);
        }

        // 得到队列中的最大值
        public int getMax(){
            return list.getFirst();
        }

        // 移出数据
        public void pop(int n){
            if(n == list.getFirst()){
                list.removeFirst();
            }
        }
    }
}


