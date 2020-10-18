package com.easy;

import org.junit.Test;

public class E172_FactorialTrailingZeroes {
    @Test
    public void myTest2(){
        int n = 145;
        int zeroCount = 0;
        for(int i = n; i >= 1; i--){
            if(i % 5 == 0){
                int temp = i;
                while(temp > 0 && temp % 5 == 0){
                    temp /= 5;
                    zeroCount++;
                }
            }
        }
        System.out.println(zeroCount);
    }
    public int trailingZeroes(int n) {
        int zeroCount = 0;
        while(n > 0){
            zeroCount += n / 5;
            n /= 5;
        }
        return zeroCount;
    }
}
