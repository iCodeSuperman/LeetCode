package com.easy;

public class E069_SqrtX {
    public int mySqrt(int a) {
        long x = a;
        while(x * x > a){
            x = (x + a / x) / 2;
        }

        return (int)x;
    }
}
