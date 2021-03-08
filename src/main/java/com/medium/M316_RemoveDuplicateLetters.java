package com.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class M316_RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        // 判断字符在不在栈内
        boolean[] InStack = new boolean[256];
        // 对单个字符计数，若数量>=2，可以比较字典序号时可以pop，否则直接入栈(注意什么时候减)
        int[] count = new int[256];
        // 栈，保证元素顺序和原字符串s相同
        Deque<Character> st = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c]++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 每遍历过的字符，都减去1
            count[c]--;
            // 去重
            if(InStack[c]) continue;

            while(!st.isEmpty() && st.peek() > c){
                // 3. 某个字符值存在一个，则不能删除
                if(count[st.peek()] == 0){
                    break;
                }
                InStack[st.pop()] = false;
            }
            st.push(c);
            InStack[c] = true;
        }

        StringBuffer sb = new StringBuffer();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}
