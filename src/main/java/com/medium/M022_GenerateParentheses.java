package com.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M022_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        if(n == 0) return new ArrayList<String>();
        List<List<String>> dp = new ArrayList<>(n);
        dp.add(new ArrayList<String>(Arrays.asList(""))); //添加第一个状态 “”

        for(int i = 1; i <= n; i++){
            List<String> cur = new ArrayList<>();
            for(int j = 0; j < i; j++){
                List<String> aList = dp.get(j);
                List<String> bList = dp.get(i - j - 1);
                for (String a : aList) {
                    for (String b : bList) {
                        cur.add("(" + a + ")" + b);
                    }
                }
            }
            dp.add(cur);
        }

        return dp.get(n);
    }
    @Test
    public void t(){
       List<String> res = generateParenthesis(3);
        for (String r : res) {
            System.out.println(r);
        }
    }
}
