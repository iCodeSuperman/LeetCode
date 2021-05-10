package com.ToOffer;

import org.junit.Test;

public class Offer046 {
    private int counts = 0;
    private char[] nums;
    public int translateNum(int num) {
        nums = Integer.toString(num).toCharArray();

        dfs(0, nums.length);
        return counts;
    }

    public void dfs(int index, int len){
        if(index >= len){
            counts++;
            return;
        }
        int v1 = nums[index] - '0';
        int v2 = v1 * 10;
        if(index + 1 < len){
            v2 += nums[index + 1] - '0';
        }else{
            // 防止XXX2 -> 20
            v2 += 10;
        }

        dfs(index + 1, len);
        if(v1 <= 2 && v2 <= 25){
            dfs(index + 2, len);
        }

    }

    @Test
    public void t(){
        System.out.println(this.translateNum(1234));
    }
}
