package com.hard;

public class H045_JumpGame2 {
    public int jump(int[] nums) {
        int len = nums.length;
        int end = 0;
        int farthest = 0;
        int ans = 0;
        for(int i = 0; i < len - 1; i++){
            farthest = Math.max(farthest, i + nums[i]);
            if(i == end){
                end = farthest;
                ans++;
            }
        }
        return ans;
    }
}
