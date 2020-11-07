package com.medium;

import org.junit.Test;

import java.sql.SQLOutput;

public class M050_Powxn {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1 / quickMul(x, -N);
    }

    public double quickMul(double x, long N){
        if(N == 0){
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public double myPow2(double x, int n){
        long N = n;
        return N >= 0 ? quickMul2(x, N) : 1.0 / quickMul2(x, -N);
    }

    public double quickMul2(double x, long N){
        double x_contributor = x;
        double ans = 1.0;
        while(N > 0){
            if(N % 2 == 1){
                ans *= x_contributor;
            }
            x_contributor *= x_contributor;
            N /= 2;
        }
        return ans;
    }

    @Test
    public void t(){
        System.out.println(this.myPow2(2, 2));
        System.out.println(this.myPow2(2, -2));
        System.out.println(this.myPow2(2, -2147483648));
    }
}
