package com.ToOffer;

/**
 * @author icodeboy
 */
public class Offer047 {
    public int maxValue1(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        for (int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < cols + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[rows][cols];
    }


    private int[][] grid;
    private int[][] old;
    private int m, n, maxV = 0;
    public int maxValue(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        old = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                old[i][j] = -1;
            }
        }
        dfs(0,0,0);
        return maxV;
    }

    public void dfs(int row, int col, int value){
        if(row >= m || col >= n){
            return;
        }
        if(row == m - 1 && col == n - 1){
            value += grid[row][col];
            maxV = value > maxV ? value : maxV;
            return;
        }

        value += grid[row][col];
        if(old[row][col] >= value){
            value -= grid[row][col];
            return;
        }else{
            old[row][col] = value;
            dfs(row + 1, col, value);
            dfs(row, col + 1, value);
        }

    }
}
