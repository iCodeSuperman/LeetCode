package second;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * 1. 暴力 超时
 * 2. 最大堆 超时
 * 3. 双向队列：左出右进，进的时候循环，比新进元素小的都出队。可以保证左边到右边，从大到小，且出去的时候依旧有序有替代知
 */
public class Q239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int resLen = len - k + 1;
        int[] res = new int[resLen];
        int left = -1, right = -1, count = 0;

        // 左大右小，左出右进
        Deque<Integer> deque = new ArrayDeque<>();
        while(right < len - 1){
            right++;
            while(deque.size() > 0 && deque.getLast() < nums[right]){
                deque.removeLast();
            }
            deque.addLast(nums[right]);

            if(right - left >= k){
                res[count] = deque.getFirst();
                count++;
                left++;
                if(nums[left] == deque.getFirst()){
                    deque.removeFirst();
                }
            }
        }

        return res;
    }






    public int[] maxSlidingWindow2(int[] nums, int k) {
        int len = nums.length;
        int resLen = len - k + 1;
        int[] res = new int[resLen];

        int left = -1, right = -1, count = 0, max = Integer.MIN_VALUE;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(k, (a, b) -> {
            return b.compareTo(a);
        });
        while(right < len - 1){
            right++;
            // 2. 只放这里，错误。求窗口内的最大值，k=1，为nums[right]自己。
            //max = max > nums[right] ? max : nums[right];
            if(right - left >= k) {
                // 3. 超时
                // priorityQueue.add(nums[right]);
                // res[count] = (int) priorityQueue.peek();
                // count++;
                // left++;
                // if(left >= 0){
                //     priorityQueue.remove(nums[left]);
                // }

                // 1. 正确，但是超时
                // int max = Integer.MIN_VALUE;
                // for (int i = left; i <= right; i++) {
                //     max = max > nums[i] ? max : nums[i];
                // }
                // [left, right] 找最小值，left更新，可能会排除掉原最大值；right更新，可能会加入新最大值。
                //priorityQueue.poll();
            }else{
                priorityQueue.add(nums[right]);
            }
        }

        return res;
    }

    @Test
    public void t(){
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = this.maxSlidingWindow(arr, k);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
