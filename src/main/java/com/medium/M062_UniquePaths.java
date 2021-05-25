package com.medium;

public class M062_UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for(int i = 1; i < m; i++){
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for(int i = 1; i < m; i++){
            for (int j = 1; j < n; j++) {
                /**
                 *  第一个dp[j] 表示第i轮的dp[j]，是个要求的新值
                 *  第二个dp[j] 表示第i-1轮的dp[j]，是个已知的结果
                 *  因为j=0的时候，值为1，保持不变
                 */
                dp[j] = dp[j] + dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}
