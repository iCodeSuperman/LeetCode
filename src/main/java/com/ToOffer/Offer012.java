package com.ToOffer;

import org.junit.Test;

/**
 * @author icodeboy
 */
public class Offer012 {
    char[] words;
    /**
     * 上右下左
     */
    int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int row, col, len;
    public boolean exist(char[][] board, String word) {
        len = word.length();
        words = word.toCharArray();
        //行数*列数
        row = board.length;
        col = board[0].length;
        boolean[][] isVisited = new boolean[row][col];

        boolean isExist = false;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(words[0] == board[i][j]){
                    isVisited[i][j] = true;
                    isExist = dfs(board, i, j, 0 + 1, isVisited);
                    isVisited[i][j] = false;
                    if(isExist){
                        return true;
                    }
                }
            }
        }
        return isExist;
    }

    public boolean dfs(char[][] board, int i, int j, int index, boolean[][] isVisited){
        if(index == len){
            return true;
        }
        boolean isExist = false;

        // 新坐标
        int x, y;
        for(int k = 0; k < 4; k++){
            x = i + direction[k][0];
            y = j + direction[k][1];
            if(isNotOutOfBounds(x, y) && !isVisited[x][y] && board[x][y] == words[index]){
                isVisited[x][y] = true;
                isExist = isExist || dfs(board, x, y, index + 1, isVisited);
                isVisited[x][y] = false;
            }
        }
        return isExist;
    }

    public boolean isNotOutOfBounds(int i, int j){
        if(i < 0 || i >= row){
            return false;
        }
        if(j < 0 || j >= col){
            return false;
        }
        return true;
    }


    @Test
    public void test(){
        char [][] tempArr1 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String tempWord1 = "ABCCED";

        char [][] tempArr = {{'A'},{'A'}};
        String tempWord = "AAA";

        boolean ans = this.exist(tempArr, tempWord);
        System.out.println(ans);
    }
}
