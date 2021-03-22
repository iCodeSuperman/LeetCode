package com.hard;

public class H037_SudokuSolver {
    public void solveSudoku(char[][] board) {
        dfs(board);
    }

    public boolean dfs(char[][] board){
        for(int i = 0; i < board.length; i++){ //rows
            for(int j = 0; j < board[0].length; j++){ //cols
                if(board[i][j] != '.') {
                    continue;
                }
                for(char k = '1'; k <= '9'; k++){
                    if(isValid(i, j, k, board)){
                        board[i][j] = k;
                        if(dfs(board)){ // When a feasible solution appears, return immediately
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    public boolean isValid(int row, int col, char val, char[][] board){
        //Determine whether the row element is repeated
        for(int j = 0; j < board[0].length; j++){
            if(board[row][j] == val){
                return false;
            }
        }

        //Determine whether the col element is repeated
        for(int i = 0; i < board.length; i++){
            if(board[i][col] == val){
                return false;
            }
        }

        //Determine whether the 3x3 sub-boxes of the grid element is repeated
        int rowStart = (row / 3) * 3; // [0-8] -> 8 / 3 * 3 = 6(第三子宫格); 2 / 3 * 3 = 0(第一子宫格);
        int colStart = (col / 3) * 3;
        for(int i = rowStart; i < rowStart + 3; i++){
            for(int j = colStart; j < colStart + 3; j++){
                if(board[i][j] == val){
                    return false;
                }
            }
        }

        return true;
    }
}
