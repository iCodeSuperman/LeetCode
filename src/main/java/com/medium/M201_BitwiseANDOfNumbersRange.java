package com.medium;

import org.junit.Test;

public class M201_BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int left, int right) {
        int ans = 0;
        int mask = 1;
        mask = mask << 30;
        while(mask > 0 && (left & mask) == (right & mask)){
            ans |= mask & left;
            mask >>= 1;
        }
        return ans;
    }

    @Test
    public void t(){
        this.rangeBitwiseAnd(10, 20);
    }
}
