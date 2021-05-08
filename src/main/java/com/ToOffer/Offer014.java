package com.ToOffer;

import org.junit.Test;

public class Offer014 {
    public int cuttingRope(int n) {
        if(n <= 3){
            return n - 1;
        }

        int a = n / 3;
        int b = n % 3;
        if(b == 0){
            return (int)Math.pow(3, a);
        }else if (b == 1){
            return (int)Math.pow(3, a - 1) * 4;
        }else if(b == 2){
            return (int)Math.pow(3, a) * 2;
        }
        return -1;
    }

    @Test
    public void t(){
        int mul = 1;
        for (int i = 0; i < 12; i++) {
            mul *= 3;
        }
        System.out.println(mul);
    }
}
