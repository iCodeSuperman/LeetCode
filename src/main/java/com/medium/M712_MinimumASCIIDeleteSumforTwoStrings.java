package com.medium;

import org.junit.Test;

public class M712_MinimumASCIIDeleteSumforTwoStrings {
    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp =new int[len1 + 1][len2 + 1];
        for(int i = 1; i < len1 + 1; i++){
            dp[i][0] = s1.charAt(i - 1) + dp[i - 1][0];
        }
        for(int j = 1; j < len2 + 1; j++){
            dp[0][j] = s2.charAt(j - 1) + dp[0][j - 1];
        }
        for(int i = 1; i < len1 + 1; i++){
            for(int j = 1; j < len2 + 1; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.min(
                            dp[i][j - 1] + s2.charAt(j - 1),
                            dp[i - 1][j] + s1.charAt(i - 1)
                    );
                }
            }
        }
        return dp[len1][len2];
    }
    public int mds(String s1, String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        int[] dp = new int[len2 + 1];
        int[] initValue = new int[len1 + 1];
        for(int i = 1; i < len1 + 1; i++){
            initValue[i] = s1.charAt(i - 1) + initValue[i - 1];
        }
        for(int i = 1; i < len2 + 1; i++){
            dp[i] = s2.charAt(i - 1) + dp[i - 1];
        }
        for(int i = 1; i < len1 + 1; i++){
            int prev = initValue[i - 1];
            dp[0] = initValue[i];
            for(int j = 1; j < len2 + 1; j++){
                int temp = dp[j];
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[j] = prev;
                }else{
                    dp[j] = Math.min(
                            dp[j - 1] + s2.charAt(j - 1),
                            dp[j] + s1.charAt(i - 1)
                    );
                }
                prev = temp;
            }
        }
        return dp[len2];
    }

    @Test
    public void t(){
        String s1 = "sea";
        String s2 = "eat";
        System.out.println(this.mds(s1, s2));
    }
}
