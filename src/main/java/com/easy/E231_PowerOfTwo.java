package com.easy;

public class E231_PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        // int res = 0;
        // while(n != 0){
        //     n = n & (n - 1);
        //     res++;
        // }
        // return res == 1;


        // 2^0 = 1 = 0b0001
        // 2^1 = 2 = 0b0010
        // 2^2 = 4 = 0b0100
        return (n & (n - 1)) == 0;
    }
}
