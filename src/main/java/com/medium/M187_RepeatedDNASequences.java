package com.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class M187_RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        if(len <= 10) return new ArrayList<>();
        Set<Integer> st = new HashSet<>();
        Set<String> res = new HashSet<>();

        int key = 0;
        for(int i = 0; i < 10; i++){
            key = key << 3; //左移3位
            key = key | s.charAt(i) & 7; //取出字符，同7(...0111)相与，只保留3位，添加到key
        }
        st.add(key);

        for(int i = 10; i < len; i++){
            key = key << 3; // 左移3位
            key = key | s.charAt(i) & 7;
            key = key & (0x3fffffff); // 和30个1相与，保留后30位
            if(st.contains(key)){
                res.add(s.substring(i - 9, i + 1));
            }else{
                st.add(key);
            }
        }

        return new ArrayList<>(res);
    }


    public void myPrint(int key){
        System.out.println(Integer.toBinaryString(key));
    }

    @Test
    public void test(){
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        String s2 = "CCCCCAAAAACCCCCCAAAAAGGGTTT";
        this.findRepeatedDnaSequences(s);
    }
}
