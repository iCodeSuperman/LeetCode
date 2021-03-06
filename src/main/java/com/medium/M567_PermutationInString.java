package com.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M567_PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(int i = 0; i < s1.length(); i++){
            char c = s1.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0; //窗口的左右指针[left, right);
        int valid = 0; // 窗口的大小是否达到s1的大小

        while(right < s2.length()){
            char c = s2.charAt(right);
            right++;
            if(needs.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c).intValue() == needs.get(c).intValue()){
                    valid++;
                }
            }

            while(right - left >= s1.length()){
                if(valid == needs.size()){
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if(needs.containsKey(d)){
                    if(window.get(d).intValue() == needs.get(d).intValue()){
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }
}
