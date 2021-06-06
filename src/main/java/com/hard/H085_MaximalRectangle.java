package com.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author icodeboy
 */
public class H085_MaximalRectangle {
    

    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // 求出每一行的heights数组，即高度矩阵
        int[][] heights = new int[m][n + 2];
        for (int i = 0; i < m; i++) {
            heights[i][0] = 0;
            for (int j = 0; j < n; j++) {
                if(i >= 1){
                    if(matrix[i][j] == '1'){
                        heights[i][j + 1] = heights[i - 1][j + 1] + 1;
                    }else{
                        heights[i][j + 1] = 0;
                    }
                }else{
                    heights[i][j + 1] = matrix[i][j] - '0';
                }
            }
            heights[i][n + 1] = 0;
        }

        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n + 2; j++) {
        //         System.out.print(heights[i][j] + " ");
        //     }
        //     System.out.println();
        // }


        int res = 0;
        // 套用 LeetCode 084的单调栈
        for (int i = 0; i < m; i++) {
            // 单调栈，存的是下标
            Deque<Integer> st = new ArrayDeque<>();
            st.addLast(0);
            for (int j = 1; j < n + 2; j++) {
                while(heights[i][st.getLast()] > heights[i][j]){
                    int h = heights[i][st.removeLast()];
                    int w = j - st.getLast() - 1;
                    res = Math.max(res, h * w);
                }
                st.addLast(j);
            }
        }
        return res;
    }


    public int maximalRectangle2(char[][] matrix) {
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
