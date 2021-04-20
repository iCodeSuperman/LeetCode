package com.ToOffer;

/**
 * @author icodeboy
 */
public class Offer10_1 {
    public int fib(int n) {
        if(n == 0 || n == 1){
            return n == 0 ? 0 : 1;
        }
        int a = 0;
        int b = 1;
        for(int i = 2; i <= n; i++){
            int temp = (a + b) % 1000000007;
            a = b;
            b = temp;
        }
        return b;
    }
}
