package second;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author icodeboy
 * 581. 最短无序连续子数组
 */
public class Q581 {

    /**
     * 方法二：单调栈
     * @param nums
     * @return
     */
    public int findUnsortedSubarray2(int[] nums) {
        int len = nums.length;
        Deque<Integer> st1 = new ArrayDeque<>(len);
        Deque<Integer> st2 = new ArrayDeque<>(len);

        int left = len, right = 0;
        for (int i = 0; i < len; i++) {
            // 单调递增栈
            while(!st1.isEmpty() && nums[st1.peek()] > nums[i]){
                left = Math.min(left, st1.removeLast());
            }
            st1.addLast(i);
        }

        for (int i = len - 1; i >= 0; i++) {
            while(!st2.isEmpty() && nums[st2.peek()] < nums[i]){
                right = Math.max(right, st2.removeLast());
            }
            st2.addLast(i);
        }

        int res = right - left + 1;
        return res > 0 ? res : 0;
    }

    /**
     * 方法一：排序
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int[] sortNums = new int[len];
        for (int i = 0; i < len; i++) {
            sortNums[i] = nums[i];
        }
        Arrays.sort(sortNums);

        int start = len, end = 0;
        for (int i = 0; i < len; i++) {
            if(nums[i] != sortNums[i]){
                start = Math.min(i, start);
                end = Math.max(i, end);
            }
        }

        int res = end - start + 1;
        return res > 0 ? res : 0;
    }
}
