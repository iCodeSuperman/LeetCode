package com.hard;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author icodeboy
 */
public class H084_LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int res = 0;
        if(len == 0){
            return res;
        }
        if(len == 1){
            return heights[0];
        }

        // 添加头尾哨兵：新建数组，第一个和最后一个元素置为0，中间为原来数组。
        len = len + 2;
        int[] newHeights = new int[len];
        newHeights[0] = 0;
        for (int i = 0; i < len - 2; i++) {
            newHeights[i + 1] = heights[i];
        }
        newHeights[len - 1] = 0;
        heights = newHeights;

        // 单调栈，存的是heights数组元素的下标
        Deque<Integer> st = new ArrayDeque<>(len);
        st.addLast(0);

        for (int i = 1; i < len; i++) {
            // 新元素比栈顶元素小，就出栈
            while(heights[i] < heights[st.getLast()]){
                int curHeight = heights[st.removeLast()];
                // 特别注意：这里右下标为i，左下标是目前还在栈里面的栈顶元素。
                // 一定会有依然在站里面的，例如左哨兵
                int curWidth = i - st.getLast() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            st.addLast(i);
        }

        return res;
    }


}
