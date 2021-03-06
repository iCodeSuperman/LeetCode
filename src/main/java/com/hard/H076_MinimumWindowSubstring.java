package com.hard;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class H076_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> needs, window;
        needs = new HashMap<>();
        window = new HashMap<>();

        /**
         * 若t为 abcc，则needs={a:1, b:1, c:2}
         */
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0; // 窗口左右指针[left, right)
        int valid = 0;  // 是否覆盖了所有有效值
        int start = 0, len = Integer.MAX_VALUE; //最小窗口的起点和长度

        while(right < s.length()){
            char c = s.charAt(right); // c是将进入窗口的字符
            right++; //窗口右移动
            if(needs.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+ 1);
                /**
                 * 特别注意：这里为Integer对象，不能用==比较，要用equals或转int比较
                 */
                if(window.get(c).intValue() == needs.get(c).intValue()){
                    /**
                     * valid的值为不同字符个数，即覆盖了t的全部。
                     * 若t为abc，valid为3
                     * 若t为abcc，valid为3
                     * 注意相加的条件
                     *  window[c] == needs[c] == 2; valid才自加
                     */
                    valid++;
                }
            }

            while(valid == needs.size()){
                // 更新最小窗口的值
                if(right - left < len){
                    start = left;
                    len = right - left;
                }

                char d = s.charAt(left);
                left++;

                if(needs.containsKey(d)){
                    if(window.get(d).intValue() == needs.get(d).intValue()){
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }



        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }


    @Test
    public void t(){
        String s = "ADOBECODCEBANC";
        String t = "ABCC";

        this.minWindow(s, t);
    }
}
