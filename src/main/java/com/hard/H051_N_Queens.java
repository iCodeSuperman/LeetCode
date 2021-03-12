package com.hard;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class H051_N_Queens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        dfs(res, board, n, 0);
        return res;
    }

    public void dfs(List<List<String>> res, char[][] board, int n, int row){
        if(n == row){
            List<String> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                list.add(String.valueOf(board[i]));
            }
            res.add(list);
            return;
        }

        for(int col = 0; col < n; col++){
            if(isValid(board, row, col, n)){
                board[row][col] = 'Q';
                dfs(res, board, n, row + 1);
                board[row][col] = '.';
            }
        }
    }

    public boolean isValid(char[][] board, int row, int col, int n){
        //注意，这里值判断第row行以及之前的是否符合，以为row+1行没有值
        // 1. 水平方向是否有Q
        for(int i = 0; i < n; i++){
            if(board[row][i] == 'Q'){
                return false;
            }
        }

        // 2. 左上方是否有Q
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(board[row][col] == 'Q'){
                return false;
            }
        }

        // 3. 右上方是否有Q
        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++){
            if(board[row][col] == 'Q'){
                return false;
            }
        }

        return true;
    }

    @Test
    public void t(){
        char[][] board = new char[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = '.';
            }
        }

        board[0][0] = 'Q';
        board[1][1] = 'Q';
        board[2][2] = 'Q';
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            list.add(String.valueOf(board[i]));
        }

        for (String s : list) {
            System.out.println(s);
        }

        res.add(list);
        res.add(list);

        for (List<String> l : res) {
            System.out.println(l);
        }

    }
}
