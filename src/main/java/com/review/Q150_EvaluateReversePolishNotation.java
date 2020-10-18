package com.review;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0; i < tokens.length; i++){
            if(isOperator(tokens[i])){
                int b = st.removeLast();
                int a = st.removeLast();
                st.addLast(cal(a, b, tokens[i]));
            }else{
                st.addLast(stringToInt(tokens[i]));
            }
        }

        return st.getLast();
    }

    public boolean isOperator(String op){
        if(op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")){
            return true;
        }else{
            return false;
        }
    }

    public int stringToInt(String s){
        return Integer.parseInt(s);
    }

    public int cal(int a, int b, String op){
        if(op.equals("+")){
            return a + b;
        }else if(op.equals("-")){
            return a - b;
        }else if(op.equals("*")){
            return a * b;
        }else if(op.equals("/")){
            return a / b;
        }else{
            throw new IllegalArgumentException("输入不正确，请检查");
        }
    }

    @Test()
    public void t(){
        String[] exp = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int ans = this.evalRPN(exp);
        System.out.println(ans);
    }
}
