package com.medium;

import org.junit.Test;

public class M300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums == null){
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        for(int i = 0; i < len; i++){
            dp[i] = 1;
        }
        for(int i = 1;i < len; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

            for(int k = 0; k < len; k ++){
                System.out.print(dp[k] + " ");
                if(k == len - 1) {
                    System.out.println();
                }
            }

        }
        int maxI = 0;
        for(int i = 0; i < len; i++){
            if(maxI < dp[i]){
                maxI = dp[i];
            }
        }
        return maxI;
    }

    public int lengthOfLIS2(int[] nums) {
        if(nums == null){
            return 0;
        }
        int len = nums.length;
        int[] tails = new int[len];
        tails[0] = nums[0];
        int count = 0;
        for(int i = 1; i < len; i++){
            if(nums[i] > tails[count]){
                tails[++count] = nums[i];
            }else{
                int left = 0, right = count;
                while(left < right){
                    int mid = left + (right - left) / 2;
                    if(tails[mid] == nums[i]){
                        right = mid;
                        break;
                    }else if(tails[mid] < nums[i]){
                        left = mid + 1;
                    }else if(tails[mid] > nums[i]){
                        right = mid;
                    }
                }
                tails[right] = nums[i];
            }
        }

        return count + 1;
    }


    @Test
    public void t(){
        int[] arr = {1,3,5,4,7};
        System.out.println(this.lengthOfLIS(arr));
    }
}
