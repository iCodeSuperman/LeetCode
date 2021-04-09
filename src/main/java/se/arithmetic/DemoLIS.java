package se.arithmetic;

import org.junit.Test;

import java.util.Arrays;

public class DemoLIS {
    public void lis(int[] nums){
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for(int i = 0; i < len; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++){
           if(dp[i] > res){
               res = dp[i];
           }
        }
        System.out.println(res);
    }

    public void lis2(int[] nums){
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for(int i = 0; i < len; i++){
            int left = 0;
            int right = i;
        }

        int res = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++){
            if(dp[i] > res){
                res = dp[i];
            }
        }
        System.out.println(res);
    }

    @Test
    public void t(){
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        lis(arr);
    }
}
