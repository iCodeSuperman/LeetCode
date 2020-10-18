package com.easy;

import java.util.HashMap;

public class E038_CountAndSay2 {
    private static HashMap<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(1, "1");
        for(int i = 2; i <= 30; i++){
            map.put(i, nextString(map.get(i - 1)));
        }
    }

    public String countAndSay(int n) {
        return map.get(n);
    }

    public static String nextString(String str){

        String next = "";
        char pre = str.charAt(0), now;
        int len = 1;

        for(int i = 1; i < str.length(); i++){
            now = str.charAt(i);
            if(pre != now){
                next = next + len + pre;
                len = 1;
            }else{
                len++;
            }
            pre = str.charAt(i);
        }
        next = next + len + pre;
        return next;
    }

}
