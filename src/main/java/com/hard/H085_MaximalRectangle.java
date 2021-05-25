package com.hard;

/**
 * @author icodeboy
 */
public class H085_MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int res = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        // 初始化，将dp[][]的第一列初始化为matrix的第一列
        for(int i = 0; i < m; i++){
            dp[i][0] = matrix[i][0];
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果matrix(i,j)是0，则不进行后续操作
                if(matrix[i][j] == 0){
                    dp[i][j] = 0;
                    continue;
                }
                // dp[i][j]：在matrix(i,j)不为0的时候，第i行有连续的几个1
                // dp(2,3)=2：第2行第3列有连续的两个1
                if(j != 0){
                    dp[i][j] = dp[i][j - 1] + 1;
                }

                int row = 1, min = Integer.MAX_VALUE;
                for(int x = i; x >= 0; x--){
                    /**
                     * 精髓在于min，取较小的那个
                     */
                    min = Math.min(min, dp[x][j]);
                    res = Math.max(res, row * min);
                    row++;
                }
            }
        }
        return res;
    }
}
