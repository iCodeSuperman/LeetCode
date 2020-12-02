package com.tempfiles;

import java.io.IOException;
import java.util.Stack;


public class ExpCal2 {

    // 定义两个栈
    private static Stack<Character> stackOpr = new Stack<>();
    private static Stack<Integer> stackNum = new Stack<>();

    // 计算表达式
    public static void main(String [] args) throws IOException {
        char c = (char)System.in.read();
        stackOpr.push('#');

        while(c != '#' || stackOpr.peek() != '#'){
            if(isNum(c)){
                stackNum.push(c - 48);
                c = (char)System.in.read();
            }else{
                switch(isPrior(c)){
                    case '<':
                        int a = stackNum.pop();
                        int b = stackNum.pop();
                        stackNum.push(operation(b, a, stackOpr.pop()));
                        break;
                    case '>':
                        stackOpr.push(c);
                        c = (char)System.in.read();
                        break;
                    case '=':
                        stackOpr.pop();
                        c = (char)System.in.read();
                        break;
                }
            }
        }
        System.out.println(stackNum.pop());
    }


    // 判断字符的优先级
    static char isPrior(char c){
        char c1 = stackOpr.peek();
        if(c == '+' || c == '-'){
            if(c1 == '+' || c1 == '-' || c1 == '*' || c1 == '/' || c1 == ')')
                return '<';
            if(c1 == '(' || c1 == '#')
                return '>';
        }

        if(c == '*' || c == '/'){
            if(c1 == '*' || c1 == '/' || c1 == ')')
                return '<';

            if(c1 == '+' || c1 == '-' || c1 == '#' || c1 == '(')
                return '>';
        }

        if(c == '('){
            return '>';
        }

        if(c == ')'){
            if(c1 == '(')
                return '=';
            else
                return '<';
        }

        if(c == '#'){
            if(c1 == '#')
                return '=';
            else
                return '<';
        }
        return 0;
    }


    // 计算当前表达式
    static int operation(int a, int b, char c){
        switch(c){
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0;
    }

    // 判断是否为数字
    static boolean isNum(char c){
        if(c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')' || c =='#'){
            return false;
        }
        return true;
    }

}
