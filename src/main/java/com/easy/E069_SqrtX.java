package com.easy;

import org.junit.Test;

public class E069_SqrtX {
    public int mySqrt(int a) {
        return (int)Math.round(mySqrtForDouble(a));
    }

    public double mySqrtForDouble(double x){
        if(x == 0 || x == 1){
            return x;
        }
        double left = 0;
        double right = x;
        // 如果是纯小数情况，则二分区间要变一变
        // x=0.01 ==> res=0.1 [0.01 0.1 1]
        if(x > 0 && x < 1){
            left = x;
            right = 1;
        }
        while(right - left >= 1e-8){
            double mid = (right - left) / 2 + left;
            if(mid > x / mid){
                right = mid;
            }else{
                left = mid;
            }
        }
        return left;
    }
    // public double mySqrtForPureDouble(double x){
    //     double left = x;
    //     double right = 1;
    //     while(right - left >= 1e-8){
    //         double mid = (right - left) / 2 + left;
    //         if(mid > x / mid){
    //             right = mid;
    //         }else{
    //             left = mid;
    //         }
    //     }
    //     return left;
    // }

    @Test
    public void t(){
        double v = 13;
        double val1 = Math.sqrt(v);
        double val2 = mySqrtForDouble(v);
        System.out.printf("自带库函数=%.6f; 我的=%.6f \n", val1, val2);
    }

    @Test
    public void t2(){
        System.out.printf("%.10f\n", 1e-8);
    }
}
