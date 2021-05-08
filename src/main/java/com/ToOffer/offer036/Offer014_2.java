package com.ToOffer.offer036;

import org.junit.Test;

public class Offer014_2 {
    public int cuttingRope(int n) {
        if(n <= 3){
            return n - 1;
        }

        int a = n / 3;
        int b = n % 3;
        int p =1000000007;

        if(b == 0){
            return (int)(pow(3, a, p) % p);
        }else if (b == 1){
            return (int)(pow(3, a - 1, p) * 4 % p);
        }else if(b == 2){
            return (int)(pow(3, a, p) * 2 % p);
        }
        return -1;
    }

    public long pow(int x, int y, int p){
        long res = 1;
        for(int i = 0; i < y; i++){
            res = (res * x) % p;
        }
        return res ;
    }

    @Test
    public void t(){
        double res = Math.pow(10, 9)*3 - Integer.MAX_VALUE;
        System.out.printf("%.2f\n", res);
    }
}
