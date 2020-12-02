package com;

public class H072_EditDistance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for(int i = 1; i <= len1; i++){
            dp[i][0] = i;
        }
        for(int j = 1; j <= len2; j++){
            dp[0][j] = j;
        }

        //当i==-1||j==-1时，返回，这里下标最小到0，所以要做偏移
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                   dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = min(
                            dp[i][j - 1] + 1, // 插入
                            dp[i - 1][j] + 1, // 删除
                            dp[i - 1][j - 1] + 1 // 替换
                    );
                }
            }
        }
        return dp[len1][len2];
    }

    public int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }

}
