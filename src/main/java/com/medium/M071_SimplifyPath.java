package com.medium;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class M071_SimplifyPath {
    public String simplifyPath(String path) {
        String[] arrStr = path.split("/");
        Deque<String> st = new ArrayDeque<>();

        for (String s : arrStr) {
            if(s.equals("..")){
                if(!st.isEmpty()){
                    st.removeLast();
                }
            }else{
                if(!s.equals("") && !s.equals(".")){
                    st.addLast(s);
                }
            }
        }
        if(st.isEmpty()){
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append("/" + st.removeFirst());
        }
        return sb.toString();
    }

    @Test
    public void test(){
        String path = "/home//foo/";
        System.out.println(simplifyPath(path));
    }
}
