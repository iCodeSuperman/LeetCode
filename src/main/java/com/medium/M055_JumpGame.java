package com.medium;

public class M055_JumpGame {
    /**
     * 1. 重点不在于跳几步，而是最大的覆盖范围；范围内，随便跳；
     * 2. 先看能不能到x位置，能到就跳，并且更新最大跳跃范围f=max(f, x+nums[x])；
     * 3. 若遍历的x > f，则表明到不了了，返回false
     * 4. 若遍历的f > 数组长度，则表明一定能到，直接返回true
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int farthest = 0;
        for(int i = 0; i < len; i++){
            farthest = Math.max(farthest, i + nums[i]);
            if(farthest >= len - 1) return true;
            if(farthest <= i) return false; // f <= i, 表明i+1永远到不了
        }

        return farthest >= len - 1;
    }
}
