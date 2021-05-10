package com.ToOffer;

import org.junit.Test;

public class Offer044 {
    public int findNthDigit(int n) {
        if(n == 0) return 0;
        long start = 1;
        int digit = 1;
        long count = 9;
        while(n > count){
            n = (int)(n - count);
            digit++;
            start *= 10;
            count = (long)(9 * start * digit);
        }

        long num = start + (n - 1) / digit;
        int index = (n - 1) % digit;
        return String.valueOf(num).charAt(index) - '0';
    }


    @Test
    public void t(){

    }
}
