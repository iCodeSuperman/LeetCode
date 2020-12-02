package com.medium;

import java.util.Arrays;

public class M516_LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        //初始化，s[i,j]，不存在i>j的子串
        //初始化，i==j的位置，表示s[i,i]单个字符子串
        for(int i = 0; i < len; i++){
            Arrays.fill(dp[i], 0);
            dp[i][i] = 1;
        }
        for(int i = len - 1; i >= 0; i --){
            for(int j = i + 1; j < len; j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }


    public int longestPalindromeSubseq2(String s) {
        int len = s.length();
        int[] dp = new int[len];
        //初始化，s[i,j]，不存在i>j的子串
        //初始化，i==j的位置，表示s[i,i]单个字符子串
        Arrays.fill(dp, 1);

        for(int i = len - 1; i >= 0; i --){
            int pre = 0; // 表示dp[i+1,j-1]位置的值，每一轮初值为0
            for(int j = i + 1; j < len; j++){
                int temp = dp[j]; //一维数组中，覆盖前的值为上一轮的，需要提前保存
                if(s.charAt(i) == s.charAt(j)){
                    dp[j] = pre + 2;
                }else{
                    dp[j] = Math.max(dp[j], dp[j-1]);
                }
                pre = temp; // 更新左下方的值
            }
        }
        return dp[len-1];
    }
}
