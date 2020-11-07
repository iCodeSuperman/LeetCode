package com.hard;

import org.junit.Test;

import java.sql.SQLOutput;

public class H174_DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n= dungeon[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[m][n - 1] = dp[m - 1][n] = 1;
        for(int i = m - 1; i >= 0; i--){
            for(int j =  n - 1; j >= 0; j--){
                int minn = dp[i][j + 1] < dp[i + 1][j] ? dp[i][j + 1] : dp[i + 1][j];
                int value = minn - dungeon[i][j];
                dp[i][j] = value > 1 ? value : 1;
            }
        }
        return dp[0][0];
    }


    private int row;
    private int col;
    private int global_max = Integer.MIN_VALUE;
    private int[][] cp; // 存入当前最优路径值
    private boolean[][] visited;

    public int calculateMinimumHP1(int[][] dungeon) {
        row = dungeon.length;
        col = dungeon[0].length;
        cp = new int[row][col];
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                cp[i][j] = Integer.MIN_VALUE;
                visited[i][j] = false;
            }
        }


        dp1(dungeon, 0, 0, Integer.MAX_VALUE, 0);

        if (global_max <= 0) {
            return 1 - global_max;
        }
        return 1;
    }

    /**
     * 第一版，超时
     * 改进：新建一个二维数组，存入某位置，已经求解的最优解。
     *
     * @param dungeon 二维矩阵
     * @param i       行号
     * @param j       列号
     * @param min     某条路径上的最小值
     * @param hp      当前生命值 health point
     */
    public void dp1(int[][] dungeon, int i, int j, int min, int hp) {
        if (i >= row || j >= col) {
            System.out.println(min);
            global_max = global_max > min ? global_max : min;
            return;
        }
        hp = hp + dungeon[i][j];
        min = min < hp ? min : hp;
        if (i == row - 1) {
            dp1(dungeon, i, j + 1, min, hp);
        } else if (j == col - 1) {
            dp1(dungeon, i + 1, j, min, hp);
        } else if (i < row && j < col) {
            dp1(dungeon, i, j + 1, min, hp);
            dp1(dungeon, i + 1, j, min, hp);
        }
    }


    /**
     * 不对
     * @param dungeon
     * @param i
     * @param j
     * @param min
     * @param hp
     */
    public void dp2(int[][] dungeon, int i, int j, int min, int hp) {
        if (i >= row || j >= col) {
            //System.out.println(min);
            global_max = global_max > min ? global_max : min;
            return;
        }
        // System.out.println("i = " + i + "; j = " + j);
        hp = hp + dungeon[i][j];
        min = min < hp ? min : hp;

        if (hp > cp[i][j]) {
            cp[i][j] = hp;
        }else{
            //return;
        }

        if (i == row - 1) {
            dp2(dungeon, i, j + 1, min, hp);
        } else if (j == col - 1) {
            dp2(dungeon, i + 1, j, min, hp);
        } else if (i < row && j < col) {
            dp2(dungeon, i, j + 1, min, hp);
            dp2(dungeon, i + 1, j, min, hp);
        }
    }




    @Test
    public void t(){
        int[][] d = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        int[][] d1 = {{3, 0, -3}, {-3, -2, -2}, {3, 1, -3}};
        int[][] d2 = {{3, -20, 30}, {-3, 4, 0}};
        System.out.println(this.calculateMinimumHP(d));
        System.out.println("-----------");
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(cp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
