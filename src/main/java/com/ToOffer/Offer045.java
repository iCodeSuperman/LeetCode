package com.ToOffer;

import java.util.Arrays;

/**
 * @author icodeboy
 */
public class Offer045 {
    public String minNumber(int[] nums) {
        int len = nums.length;
        String[] strs = new String[len];
        for(int i = 0; i < len; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuffer sb = new StringBuffer();
        for (String str : strs) {
            sb.append(str);
        }
        return  sb.toString();
    }
}
