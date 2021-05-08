package com.ToOffer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author icodeboy
 */
public class Offer031 {
    /**
     * 用一个辅助栈st，模拟入栈和出栈的操作
     *  - 入栈：按照压栈数组入栈
     *  - 出栈：每次入栈后，循环判断“栈顶元素 == 出栈数组当前元素”是否成立，成立则一直出栈
     * 最后判断st是否为空
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = pushed.length;
        int i = 0, j = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        while(i < len){
            deque.addLast(pushed[i]);
            while(!deque.isEmpty() && deque.getLast() == popped[j]){
                deque.removeLast();
                j++;
            }
            i++;
        }
        return deque.isEmpty();
    }
}
