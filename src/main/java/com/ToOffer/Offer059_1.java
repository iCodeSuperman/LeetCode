package com.ToOffer;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author icodeboy
 */
public class Offer059_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null) return null;
        Deque<Integer> maxQ = new ArrayDeque<>();
        int len = nums.length;
        int[] res = new int[len - k + 1];
        // window = [left, right)
        int left = 0;
        int right = 0;

        while(right < len){
            right++;

            while(!maxQ.isEmpty() && nums[right - 1] > maxQ.getLast()){
                maxQ.removeLast();
            }
            maxQ.addLast(nums[right - 1]);

            if(right - left >= k){
                res[left] = maxQ.getFirst();
                if(nums[left] == maxQ.getFirst().intValue()){
                    maxQ.removeFirst();
                }
                left++;
            }
        }
        return res;

    }

    public void print(int[] nums, int begin, int end){
        for(int i = begin; i < end; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
