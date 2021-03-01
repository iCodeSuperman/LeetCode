package com.hard;

import java.util.PriorityQueue;

public class H295_FindMedianFromDataStream {

}

class MedianFinder{

    /**
     * 用两个优先队列，分别表示大顶堆(倒三角)、小顶堆(梯形)，其中：
     *      大顶堆(倒三角)：堆顶元素为最大值 ---> small
     *      小顶堆(梯形)：堆顶元素为最小值 --->  large
     *    并保证，小顶堆元素均 >= 大顶堆元素。
     */

    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    /** initialize your data structure here. */
    public MedianFinder() {
        // 小顶堆，存放大的值
        large = new PriorityQueue<>();
        // 大顶堆，存放小的值
        small = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
    }

    public void addNum(int num) {
        /**
         * 保证两个堆元素个数的差值小于1，且small(大顶堆)的元素 <= large(小顶堆)的元素
         */

        if(small.size() >= large.size()){
            small.add(num);
            large.add(small.poll());
        }else{
            large.add(num);
            small.add(large.poll());
        }

    }

    public double findMedian() {
        if(large.size() > small.size()){
            return large.peek();
        }else if(large.size() < small.size()){
            return small.peek();
        }else{
            Integer a = large.peek();
            Integer b = small.peek();
            return 1.0 * (a - b) / 2;
        }
    }
}
