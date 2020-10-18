package com.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class E202_HappyNumber {
    public boolean isHappy(int n) {
       int slow = n;
       int fast = squareDigit(n);
        while(slow != fast){
            slow = squareDigit(slow);
            fast = squareDigit(squareDigit(fast));
        }
        return slow == 1;
    }

    public int squareDigit(int n){
        int sum = 0;
        while(n > 0){
            sum = sum + (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }

    @Test
    public void myTest(){
        System.out.println(isHappy(1));
    }
}
