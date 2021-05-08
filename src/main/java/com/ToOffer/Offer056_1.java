package com.ToOffer;

/**
 * @author icodeboy
 */
public class Offer056_1 {
    public int[] singleNumbers(int[] nums) {
        int bitmask = 0;
        for (int num : nums) {
            bitmask ^= num;
        }

        // 只保留二进制最后一位
        bitmask &= -bitmask;

        int[] res = new int[2];
        for (int num : nums) {
            if((num & bitmask) == 0){
                res[1] ^= num;
            }else{
                res[0] ^= num;
            }
        }
        return res;
    }
}
