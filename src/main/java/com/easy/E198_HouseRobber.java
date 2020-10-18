package com.easy;

public class E198_HouseRobber {
    public int rob(int[] nums) {
        int curMax = 0; //k-1
        int preMax = 0; //k-2
        for (int n : nums) {
            int temp = curMax; // pre=k-2, cur=k-1
            curMax = Math.max(preMax + n, curMax); //cur=k
            preMax = temp; //cur=k-1
        }
        return curMax; //cur=k
    }
}
