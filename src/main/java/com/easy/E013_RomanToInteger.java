package com.easy;

import java.util.HashMap;

public class E013_RomanToInteger {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int pre = map.get(s.charAt(0));
        if(s.length() == 1) return pre;
        int now, sum = 0;
        for(int i = 1; i < s.length(); i++){
            now = map.get(s.charAt(i));
            if(pre >= now){
                sum += pre;
                pre = now;
            }else{
                pre = now - pre;
            }
        }
        sum = sum + pre;
        return sum;
    }
}
