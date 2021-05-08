package com.ToOffer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Offer050 {
    public char firstUniqChar(String s) {
        int len = s.length();
        char[] alphabet = s.toCharArray();

        int[] headToTail = new int[26];
        int[] tailToHead = new int[26];
        for (int i = 0; i < len; i++) {
            headToTail[alphabet[i] - 'a']++;
        }
        for (int i = len - 1; i >= 0; i--) {
            tailToHead[alphabet[i] - 'a']++;
        }

        for(int i = 0; i < len; i++){
            if(tailToHead[i] == 1 && headToTail[i] == 1){
                return alphabet[i];
            }
        }
        return ' ';
    }
}
