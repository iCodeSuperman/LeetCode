package com.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M438_FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0 + 1));
        }

        int left = 0, right = 0, valid = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            if(needs.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0 + 1));
                if(window.get(c).equals(needs.get(c))){
                    valid++;
                }
            }

            while(right - left >= p.length()){
                if(valid == needs.size()){
                    res.add(left);
                }
                char d = s.charAt(left);
                left ++;
                if(needs.containsKey(d)){
                    if(window.get(d).equals(needs.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return res;
    }
}
