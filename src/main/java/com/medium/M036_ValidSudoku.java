package com.medium;

public class M036_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] sub = new int[9][9];

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char c = board[i][j];
                if(c != '.'){
                    int num = c - '0';
                    int boxIndex = (i / 3) * 3 + j / 3;
                    row[i][num]++;
                    col[j][num]++;
                    sub[boxIndex][num]++;
                    if(row[i][num] > 1 || col[j][num] > 1 || sub[boxIndex][num] > 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
