package com.medium;

public class M221_MaximalSquare {
    public int maximalSquare(char[][] matrix) {
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
