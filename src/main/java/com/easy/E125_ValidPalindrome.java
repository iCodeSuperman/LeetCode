package com.easy;

public class E125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null || s.isEmpty() ) return true;
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            char a = s.charAt(i);
            char b = s.charAt(j);
            if(!isAlpha(a) && !isNumber(a)){
                i++;
            }else if(!isAlpha(b) && !isNumber(b)){
                j--;
            }else if(isEqual(a, b)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }

    public boolean isNumber(char c){
        return c >= '0' && c <= '9';
    }
    public boolean isAlpha(char c){
        return c >= 'a' && c <= 'z' || c >= 'A' && c <='Z';
    }
    public boolean isEqual(char a, char b){
        // 首先比较是不是数字
        if(isNumber(a) || isNumber(b)){
            return a == b;
        }

        //忽略大小写，比较a,b两个字符是否相等（通过ASCII码）
        return a - 'a' == b - 'a' ||
                a - 'a' == b - 'A' ||
                a - 'A' == b - 'a' ||
                a - 'A' == b - 'A';
    }
}
