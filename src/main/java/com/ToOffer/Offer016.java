package com.ToOffer;

public class Offer016 {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }else if(n < 0){
            return 1.0 / (x * myPow(x, -n - 1));
        }else if(n % 2 == 0){
            return myPow(x * x, n / 2);
        }else{
            return x * myPow(x, n - 1);
        }

    }
}
