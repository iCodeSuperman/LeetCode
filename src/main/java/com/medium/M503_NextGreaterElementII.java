package com.medium;

import com.sun.jmx.remote.internal.ArrayQueue;
import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayDeque;
import java.util.Deque;

public class M503_NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Deque<Integer> st = new ArrayDeque<>();
        // 取模作为循环链 i % len -> 9 % 5 = 4
        for(int i = 2 * len - 1; i >= 0; i--){
            while(!st.isEmpty() && nums[i % len] >= st.getLast()){
                st.removeLast();
            }
            res[i % len] = st.isEmpty() ? -1 : st.getLast();
            st.addLast(nums[i % len]);
        }
        return res;
    }

    @Test
    public void t(){
        int[] n = {2, 1, 2, 4, 3};
        int[] ans = this.nextGreaterElements(n);
        for (int a : ans) {
            System.out.println(a + " ");
        }
        System.out.println();
    }
}
