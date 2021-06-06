package com.medium;

import org.junit.Test;

public class M152_MaximumProductSubarray {

    @Test
    public void t(){
        int[] arr = {1, -2};
        System.out.println(this.maxProduct(arr));
    }

    public int maxProduct(int[] nums){
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        int[] dp_max = new int[len];
        int[] dp_min = new int[len];
        dp_max[0] = nums[0];
        dp_min[0] = nums[0];

        int res = nums[0];
        for (int i = 1; i < len; i++) {
            int n = nums[i];
            dp_max[i] = Math.max(n, Math.max(dp_max[i - 1] * n, dp_min[i - 1] * n));
            dp_min[i] = Math.min(n, Math.min(dp_max[i - 1] * n, dp_min[i - 1] * n));
            System.out.println("max="+dp_max[i]+"; min="+dp_min[i]);
            res = Math.max(res, dp_max[i]);
        }
        return res;
    }


    public int maxProduct2(int[] nums) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp = 1;;
            for (int j = i; j < nums.length; j++) {
                temp *= nums[j];
                res = Math.max(temp, res);
            }
        }

        return res;
    }
}
