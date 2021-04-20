package com.medium;

import java.util.HashMap;
import java.util.Map;

public class M1234_ReplaceTheSubstringForBalancedString {
    public int balancedString(String s) {
        int[] alphabet = new int[26];
        int len = s.length();
        int avg = len / 4;
        int left = 0, right = 0, res = len;

        for (int i = 0; i < len; i++) {
            alphabet[s.charAt(i) - 'A']++;
        }

        while (right < len){
            alphabet[s.charAt(right) - 'A']--;
            while(left < len && alphabet['Q' - 'A'] <= avg && alphabet['W' - 'A'] <= avg && alphabet['E' - 'A'] <= avg && alphabet['R' - 'A'] <= avg){
                res = res > (right - left + 1) ? res : (right - left + 1);
                alphabet[s.charAt(left) - 'A']++;
                left++;
            }

            right++;
        }
        return res;
    }
}
