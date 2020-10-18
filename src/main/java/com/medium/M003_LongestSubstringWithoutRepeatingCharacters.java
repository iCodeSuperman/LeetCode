package com.medium;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class M003_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s){
        int ans = 0, n = s.length();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int j = 0, i = 0; j < n; j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = ans > j - i + 1 ? ans : j - i + 1;
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
    public int lengthOfLongestSubstring2(String s){
        int ans = 0, i = 0, j = 0;
        Set<Character> st = new HashSet<>();
        while(j < s.length() && i < s.length()){
            if(!st.contains(s.charAt(j))){
                st.add(s.charAt(j++));
                ans = ans > j - i ? ans : j - i; //[i, j)
            }else{
                st.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    public int lengthOfLongestSubstring3(String s) {
        int count = 0;
        int max = -1;
        for(int i = 0; i < s.length(); i++){
            Set<Character> st = new HashSet<>();
            for(int j = i; j < s.length(); j++){
                char c = s.charAt(j);
                if(st.contains(c)){
                    count = 0;
                    break;
                }else{
                    st.add(c);
                    count++;
                }
                if(count > max){
                    max = count;
                }
                if(i == s.length() - 1 || j == s.length() - 1){
                    return max;
                }
            }
        }
        return count;
    }
    @Test
    public void myTest(){
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
