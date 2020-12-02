package com.tempfiles;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
public class ExpCal3 {
    private Stack<String> houzhuiStack  = new Stack<String>();//后缀式栈
    private Stack<Character> yunsuanfuStack  = new Stack<Character>();//运算符栈
    private int [] operatPriority  = new int[] {0,3,2,1,-1,1,0,2};//运用运算符ASCII码-40做索引的运算符优先级

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        ExpCal3 cal  = new ExpCal3();
        String result  = cal.calculate(s);
        System.out.println(result);
    }
    /*
     *2.得到后缀表达式进行运算
     */
    public String calculate(String expression) {
        Stack<String> resultStack  = new Stack<String>();
        prepare(expression);
        Collections.reverse(houzhuiStack);//将后缀式栈反转
        String firstValue  ,secondValue,currentValue;//参与计算的第一个值，第二个值和算术运算符
        while(!houzhuiStack.isEmpty()) {
            currentValue  = houzhuiStack.pop();
            if(!isOperator(currentValue.charAt(0))) {//如果不是运算符则存入操作数栈中
                resultStack.push(currentValue);
            } else {//如果是运算符则从操作数栈中取两个值和该数值一起参与运算
                secondValue  = resultStack.pop();
                firstValue  = resultStack.pop();
                String tempResult  = calculate(firstValue, secondValue, currentValue.charAt(0));
                resultStack.push(tempResult);
            }
        }
        return resultStack.pop();
    }
    /**
     * 1数据准备阶段将表达式转换成为后缀式栈
     */
    private void prepare(String expression) {
        yunsuanfuStack.push(',');//运算符放入栈底元素逗号，此符号优先级最低
        char[] arr  = expression.toCharArray();
        int currentIndex  = 0;//当前字符的位置
        int count = 0;//上次算术运算符到本次算术运算符的字符的长度便于或者之间的数值
        char currentOp  ,peekOp;//当前操作符和栈顶操作符
        for(int i=0;i<arr.length;i++) {
            currentOp = arr[i];
            if(isOperator(currentOp)) {//如果当前字符是运算符
                if(count > 0) {
                    houzhuiStack.push(new String(arr,currentIndex,count));//取两个运算符之间的数字
                }
                peekOp = yunsuanfuStack.peek();
                if(currentOp == ')') {//遇到反括号则将运算符栈中的元素移除到后缀式栈中直到遇到左括号
                    while(yunsuanfuStack.peek() != '(') {
                        houzhuiStack.push(String.valueOf(yunsuanfuStack.pop()));
                    }
                    yunsuanfuStack.pop();
                } else {
                    while(currentOp != '(' && peekOp != ',' && compare(currentOp,peekOp) ) {
                        houzhuiStack.push(String.valueOf(yunsuanfuStack.pop()));
                        peekOp = yunsuanfuStack.peek();
                    }
                    yunsuanfuStack.push(currentOp);
                }
                count = 0;
                currentIndex = i+1;
            } else {
                count++;
            }
        }
        if(count > 1 || (count == 1 && !isOperator(arr[currentIndex]))) {//最后一个字符不是括号或者其他运算符的则加入后缀式栈中
            houzhuiStack.push(new String(arr,currentIndex,count));
        }

        while(yunsuanfuStack.peek() != ',') {
            houzhuiStack.push(String.valueOf( yunsuanfuStack.pop()));//将操作符栈中的剩余的元素添加到后缀式栈中
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
        if(operatPriority[(peek)-40] >= operatPriority[(cur) - 40]) {
            result = true;
        }
        return result;
    }
    /**
     * 按照给定的算术运算符做计算
     */
    private String calculate(String firstValue,String secondValue,char currentOp) {
        String result  = "";
        switch(currentOp) {
            case '+':
                result = String.valueOf(ArithHelper.add(firstValue, secondValue));
                break;
            case '-':
                result = String.valueOf(ArithHelper.sub(firstValue, secondValue));
                break;
            case '*':
                result = String.valueOf(ArithHelper.mul(firstValue, secondValue));
                break;
            case '/':
                result = String.valueOf(ArithHelper.div(firstValue, secondValue));
                break;
        }
        return result;
    }
    static class ArithHelper {
        // 这个类不能实例化
        private ArithHelper() {
        }
        /**
         * 提供精确的加法运算。
         * @param v1 被加数
         * @param v2 加数
         * @return 两个参数的和
         */
        public static String add(String v1, String v2) {
            java.math.BigDecimal b1 = new java.math.BigDecimal(v1);
            java.math.BigDecimal b2 = new java.math.BigDecimal(v2);
            return String.valueOf(b1.add(b2).intValue());
        }
        /**
         * 提供精确的减法运算。
         * @param v1 被减数
         * @param v2 减数
         * @return 两个参数的差
         */
        public static String sub(String v1, String v2) {
            java.math.BigDecimal b1 = new java.math.BigDecimal(v1);
            java.math.BigDecimal b2 = new java.math.BigDecimal(v2);
            return String.valueOf(b1.subtract(b2).intValue());
        }
        /**
         * 提供精确的乘法运算。
         * @param v1
         *            被乘数
         * @param v2
         *            乘数
         * @return 两个参数的积
         */
        public static String mul(String v1, String v2) {
            java.math.BigDecimal b1 = new java.math.BigDecimal(v1);
            java.math.BigDecimal b2 = new java.math.BigDecimal(v2);
            return String.valueOf(b1.multiply(b2).intValue());
        }
        /**
         * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
         * @param v1
         *            被除数
         * @param v2
         *            除数
         * @return 两个参数的商
         */
        public static String div(String v1, String v2) {
            java.math.BigDecimal b1 = new java.math.BigDecimal(v1);
            java.math.BigDecimal b2 = new java.math.BigDecimal(v2);
            return String.valueOf(b1.divideToIntegralValue(b2).intValue());
        }
    }
}