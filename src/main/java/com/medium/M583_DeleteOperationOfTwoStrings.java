package com.medium;

public class M583_DeleteOperationOfTwoStrings {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int lcsInt = lcs(word1, len1, word2, len2);
        int ans = len1 - lcsInt + len2 - lcsInt;
        return ans;
    }

    public int lcs(String text1, int len1, String text2, int len2){
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
}
