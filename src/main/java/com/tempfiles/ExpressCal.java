package com.tempfiles;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


//20+(3*(4+1)-5)/2-3
public class ExpressCal {
    private Deque<String> postFix = new ArrayDeque<>(); //后缀表达式栈
    private Deque<Character> operator = new ArrayDeque<>(); //运算符栈
    private int[] priority = new int[]{0,3,2,1,-1,1,0,2}; //运算符优先级

    public static void main(String[] args) {
        System.out.println("Please input your expression: ");

        Scanner scanner = new Scanner(System.in);
        String line = null;
        // while(scanner.hasNext()){
        //     line = scanner.nextLine();
        //     ExpressCal ec = new ExpressCal();
        //     String result = ec.calculate(line);
        //
        //     System.out.println("Result of expression is " + result);
        //     System.out.println();
        //     System.out.println("Please input your expression: ");
        // }
        line = scanner.nextLine();
        ExpressCal ec = new ExpressCal();
        int result = ec.calExpression(line);
        System.out.println(result);
    }

    public int calExpression(String expression){
        inToPost(expression);
        return calculate();
    }

    //进行计算
    public int calculate(){
        Deque<Integer> number = new ArrayDeque<>();
        String value = null;
        int a = 0, b = 0, c = 0;
        while(!postFix.isEmpty()){
            value = postFix.removeFirst();
            if(!isOperator(value.charAt(0))){
                number.addLast(stringToInt(value));
            }else{
                b = number.removeLast();
                a = number.removeLast();
                c = arithmetic(a, b, value.charAt(0));
                number.addLast(c);
            }
        }
        return number.removeLast();
    }

    //进行四则运算
    public int arithmetic(int a, int b, char op){
        int result = 0;
        switch (op){
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
        }
        return result;
    }

    public int stringToInt(String str){
        int len = str.length();
        int temp = 0;
        for(int i = 0; i < len; i++){
            temp = temp * 10 + str.charAt(i) - '0';
        }
        return temp;
    }

    //将中缀表达式转为后缀表达式
    public void inToPost(String expression){
        operator.addLast(','); //运算符放入栈底元素，此符号优先级最低
        char[] arr = expression.toCharArray();
        char currentOp, peekOp; //当前操作符和栈顶操作符
        int count = 0, currentIndex = 0;
        for(int i = 0; i < arr.length; i++){
            currentOp = arr[i];
            if(isOperator(currentOp)){
                if(count > 0){
                    String s = "";
                    for(int j = currentIndex; j < count + currentIndex; j++){
                        s += arr[j];
                    }
                    postFix.addLast(s);
                }
                peekOp = operator.getLast();
                if(currentOp == ')'){
                    while(operator.getLast() != '('){
                        String s = operator.removeLast() + "";
                        postFix.addLast(s);
                    }
                    operator.removeLast();
                }else{
                    while(currentOp != '(' && peekOp != ',' && compare(currentOp, peekOp)){
                        String s = operator.removeLast() + "";
                        postFix.addLast(s);
                        peekOp = operator.getLast();
                    }
                    operator.addLast(currentOp);
                }
                count = 0;
                currentIndex = i + 1;
            }else {
                count ++;
            }
        }

        if(count > 1 || (count == 1 && !isOperator(arr[currentIndex]))){
            String s = "";
            for(int j = currentIndex; j < count + currentIndex; j++){
                s += arr[j];
            }
            postFix.addLast(s);
        }

        while(operator.getLast() != ','){
            String s = String.valueOf(operator.removeLast());
            postFix.addLast(s);
        }
    }

    /**
     * 判断是否为算术符号
     */
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '(' ||c == ')';
    }
    /**
     * 利用ASCII码-40做下标去算术符号优先级
     */
    public  boolean compare(char cur,char peek) {// 如果是peek优先级高于cur，返回true，默认都是peek优先级要低
        boolean result  = false;
        if(priority[(peek)-40] >= priority[(cur) - 40]) {
            result = true;
        }
        return result;
    }


}
