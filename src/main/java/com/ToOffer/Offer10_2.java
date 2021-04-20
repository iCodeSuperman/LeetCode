package com.ToOffer;

public class Offer10_2 {
    public int numWays(int n) {
        if(n == 0) {
            return 1;
        }
        if(n == 1 || n == 2){
            return n == 1 ? 1 : 2;
        }
        int a = 1;
        int b = 2;
        for(int i = 3; i <= n; i++){
            int temp = (a + b) % 1000000007;
            a = b;
            b = temp;
        }
        return b;
    }
}
