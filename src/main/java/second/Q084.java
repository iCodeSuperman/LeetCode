package second;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 084. 柱状图中最大的矩形
 */
public class Q084 {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int len = heights.length;
        // 预处理，构造新数组
        int newLen = len + 2;
        int[] newHeight = new int[newLen];
        newHeight[0] = 0;
        for (int i = 1; i < newLen; i++) {
            newHeight[i] = heights[i - 1];
        }
        newHeight[newLen - 1] = 0;

        Deque<Integer> st = new ArrayDeque<>();
        st.add(0);
        for (int i = 1; i < newLen; i++) {
            while(newHeight[st.getLast()] > newHeight[i]){
                int height = newHeight[st.removeLast()];
                int width = i - st.getLast() - 1;
                int area = height * width;
                res = res > area ? res : area;
            }
            st.addLast(i);
        }

        return res;
    }
}
