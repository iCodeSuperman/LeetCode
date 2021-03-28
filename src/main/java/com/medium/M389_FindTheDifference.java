package com.medium;

import org.junit.Test;

public class M389_FindTheDifference {
    public char findTheDifference(String s, String t) {
        int val = 0;
        for(int i = 0; i < s.length(); i++){
            val = val ^ (s.charAt(i) - 'a');
        }
        for(int i = 0; i < t.length(); i++){
            val = val ^ (t.charAt(i) - 'a');
        }
        return (char)(val + 'a');
    }

    @Test
    public void t(){
        String s = "abcd";
        String t = "afdcb";
        System.out.println(this.findTheDifference(s, t));
    }
}
