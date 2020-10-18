package com.easy;

public class E190_ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        int count = 0;
        while(count < 32){
            res = res << 1;
            res = res | (n & 1);
            n = n >> 1;
            count++;
        }
        return res;
    }
}
