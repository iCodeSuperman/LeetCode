package com.medium;

import java.util.Arrays;

public class M221_MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        /**
         * 1. dp状态定义
         *  dp(i,j) 表示右下角为matrix[i-1][j-1]矩阵的最大边长
         *
         * 2. 状态转移方程
         *     木桶短板效应
         *     dp(i,j) = min(dp(i, j-1), dp(i-1, j), dp(i-1,j-1)) + 1
         * 3. base case
         *  dp[i][0] & dp[0][j] = 0
         *  有状态转移方程可知，任何一个正方形都依赖左、左上、上三个，
         *  而matrix第一行第一列没有能依赖的，所以增加一行一列，用以简化代码
         *  注意dp矩阵在matrix基础上，左边和上边开头增加一行一列
         */
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m + 1; i++) {
            Arrays.fill(dp[i], 0);
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        return maxSide * maxSide;
    }

    public int maximalSquare2(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        /**
         * dp(i,j) 表示第i行第j列，连续的1累计个数
         */
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++){
            dp[i][0] = matrix[i][0] - '0';
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                    continue;
                }
                if(j != 0){
                    dp[i][j] = dp[i][j - 1] + 1;
                }
                int row = 1, min = Integer.MAX_VALUE;
                for(int x = i; x >= 0; x--){
                    min = Math.min(dp[x][j], min);
                    //if(row == min){
                    res = Math.max(res, row * min);
                    //}
                    row++;
                }
            }
        }
        return res;
    }
}
