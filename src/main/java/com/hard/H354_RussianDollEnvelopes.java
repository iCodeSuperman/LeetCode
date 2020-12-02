package com.hard;

import java.util.Arrays;
import java.util.Comparator;

public class H354_RussianDollEnvelopes {
    /**
     * 解法概述：
     * 先对宽度 w 进行升序排序，如果遇到 w 相同的情况，则按照高度 h 降序排序。
     * 之后把所有的 h 作为一个数组，在这个数组上计算 LIS 的长度就是答案。
     * - 宽度从小到大，保证了可以嵌套
     * - 宽度相同，高度从大到小，保证了不会出现：宽度一样，高度2和3的嵌套
     * [1, 8]
     * [2, 3]
     * [5, 4]
     * [5, 2]
     * [6, 7]
     * [6, 4]
     */
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0){
            return 0;
        }

        int len = envelopes.length;
        //w从小到大，h从大到小，确保w相同时，最多只有一个h参与计算
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            }
        });

        int[] height = new int[len];
        for(int i = 0; i < len; i++){
            height[i] = envelopes[i][1];
        }

        return findLengthOfLIS(height);
    }

    int findLengthOfLIS(int[] height){
        int len = height.length;

        int[] dp = new int[len];
        for(int i = 0; i < len; i++){
            dp[i] = 1;
        }

        int count = 0;
        dp[0] = height[0];
        for(int i = 1; i < len; i++){
            if(height[i] > dp[count]){
                dp[++count] = height[i];
            }else{
                int left = 0, right = count;
                while (left < right){
                    int mid = left + (right - left) / 2;
                    if(height[i] <= dp[mid]){
                        right = mid;
                    }else{
                        left = mid + 1;
                    }
                }
                dp[right] = height[i];
            }
        }
        return count + 1;
    }
}
