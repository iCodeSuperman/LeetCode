package com.easy;

import org.junit.Test;

public class E009_PalindromeNumber {
    @Test
    public void Input(){
        int[] v = {121, -121, 1, 10, 0};
        for(int i = 0; i < v.length; i++){
            System.out.println(isPalindrome(v[i]));
        }
    }


    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) return false;
        int y = 0; // x is original numeric, and y is reverter numeric.
        while(x > y){
            int pop = x % 10;
            x = x / 10;
            y = pop + y * 10;
        }
        return x == y || x == y % 10;
        // second condition consider

    }
}
