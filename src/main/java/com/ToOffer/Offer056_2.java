package com.ToOffer;

import org.junit.Test;

/**
 * @author icodeboy
 */
public class Offer056_2 {
    public int singleNumber(int[] nums) {
        int[] digit = new int[32];

        for (int num : nums) {
            for(int i = 0; i < 31; i++){
                digit[i] += num & 1;
                num >>>= 1;
            }
        }

        int res = 0;
        for (int i = 0; i < 31; i++) {
            res = res | digit[i] % 3;
            res <<= 1;
        }
        return res;
    }

    @Test
    public void t(){
        System.out.println(1 << 2);
    }
}
