package com.easy;

import java.util.HashMap;
import java.util.Stack;

public class E020_ValidParentheses {
    private HashMap<Character, Character> mappings;

    public E020_ValidParentheses(){
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put(']', '[');
        this.mappings.put('}', '{');

    }

    public boolean isValid(String s){
        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            // 如果当前的字符是右括号，即map中的key值存在该字符，比较
            // 如果当前的字符是左括号，直接进栈
            if(this.mappings.containsKey(c)){
                //containsKey() 存在key，返回true
                char topElement = stack.empty() ? '#' : stack.pop();

                // 如果取出的左括号与当前字符不能组成一对，返回false;
                if(topElement != this.mappings.get(c)){
                    // get() 根据key值取出value
                    return false;
                }
            }else{
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
