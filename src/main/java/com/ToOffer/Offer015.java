package com.ToOffer;

public class Offer015 {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            n &= n - 1;
            count++;
        }
        return count;
    }
}
