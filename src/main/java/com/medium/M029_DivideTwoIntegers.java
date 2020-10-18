package com.medium;

public class M029_DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;
        else if(divisor == 1) return dividend;
        else if(divisor == -1){
            if(dividend > Integer.MIN_VALUE){
                return -dividend;
            }else{
                return Integer.MAX_VALUE;
            }
        }

        long a = dividend;
        long b = divisor;
        int sign = 1;
        if(a < 0 && b > 0 || a > 0 && b < 0){
            sign = -1;
        }
        a = a > 0 ? a : -a;
        b = b > 0 ? b : -b;

        long res = div(a, b);
        if(sign == -1){
            return (int)-res;
        }

        return (int)res;
    }

    public long div(long a, long b){
        if(a < b) return 0;
        long count = 0;
        long tb = b;
        while((tb + tb) <= a){
            count+=count;
            tb += tb;
        }
        return count + div(a - tb, b);
    }
}
