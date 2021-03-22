package com.tempfiles;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TwoParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n == 0) return res;
        Deque<String> st = new ArrayDeque<>();
        dfs(n, n, st, res);
        return res;
    }

    public void dfs(int left, int right, Deque<String> st, List<String> res){
        if(right < left) return;
        if(left < 0 || right < 0) return;
        if(left == 0 && right == 0){
            StringBuffer sb = new StringBuffer();
            /**
             * 注意看这段智障代码：
             *  因为双端队列全局只维持一份，这里却用remove的方式操作双端队列，导致错误
             */
            // while(!st.isEmpty()){
            //     sb.append(st.removeFirst());
            // }
            List<String> list = new ArrayList<>(st);
            for(int i = 0; i < list.size(); i++){
                sb.append(list.get(i));
            }
            res.add(sb.toString());
            return;
        }


        print(st);
        st.addLast("(");
        print(st);
        dfs(left - 1, right, st, res);
        print(st);
        st.removeLast();
        print(st);

        print(st);
        st.addLast(")");
        print(st);
        dfs(left, right - 1, st, res);
        print(st);
        st.removeLast();
        print(st);
    }

    public void print(Deque<String> st){
        System.out.println(st.toString());
    }

    @Test
    public void t(){
        List<String> res = new ArrayList<>();
        res = this.generateParenthesis(3);
        for (String re : res) {
            System.out.println(re);
        }
    }
}
