package com.easy;

public class E058_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == "") return 0;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if(count != 0) break;
            } else {
                count++;
            }
        }
        return count;
    }
}
