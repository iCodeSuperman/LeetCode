package com.medium;

import org.junit.Test;

public class M1143_LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1+1][len2+1];

        for(int i = 1; i < len1 + 1; i++){
            for(int j = 1; j < len2 + 1; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i][j - 1]
                    );
                }
            }
        }
        return dp[len1][len2];
    }

    public int lcs(String text1, String text2){
        int len1 = text1.length();
        int len2 = text2.length();
        int[] dp = new int[len2 + 1];

        for(int i = 0; i < len1; i++){
            int pre = 0;
            for(int j = 1; j < len2 + 1; j++){
                int temp = dp[j];
                if(text1.charAt(i) == text2.charAt(j - 1)){
                    dp[j] = pre + 1;
                }else{
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
                pre = temp;
            }
        }
        return dp[len2];
    }

    @Test
    public void t(){
        String s1 = "abcde";
        String s2 = "cde";
        int ans = this.longestCommonSubsequence(s1, s2);
        int ans2 = this.lcs(s1, s2);
        System.out.println(ans2);
    }
}
