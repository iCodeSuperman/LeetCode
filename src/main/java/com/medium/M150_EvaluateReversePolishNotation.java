package com.medium;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class M150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for (String token : tokens) {
            if(isOperator(token)){
                int b = st.removeLast();
                int a = st.removeLast();
                int v = cal(a, b, token);
                st.addLast(v);
            }else{
                st.addLast(Integer.parseInt(token));
            }
        }

        return st.removeLast();
    }
    public boolean isOperator(String s){
        boolean flag = false;
        switch (s){
            case "+":
                flag = true;
                break;
            case "-":
                flag = true;
                break;
            case "*":
                flag = true;
                break;
            case "/":
                flag = true;
                break;
        }
        return flag;
    }

    public int cal(int a, int b, String s){
        int c = 0;
        switch (s){
            case "+":
                c = a + b;
                break;
            case "-":
                c = a - b;
                break;
            case "*":
                c = a * b;
                break;
            case "/":
                c = a / b;
                break;
        }
        return c;
    }

    @Test
    public void t(){
        String[] s = {"1", "2", "*", "3", "4", "*", "+"};
        System.out.println(evalRPN(s));
    }

}
