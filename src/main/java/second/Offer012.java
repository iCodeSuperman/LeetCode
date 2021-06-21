package second;

public class Offer012 {
    private int rows, cols, len;
    private char[] words;
    // 上，右，下，左
    private int[][] forward = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public boolean exist(char[][] board, String word) {

        int len = word.length();
        words = word.toCharArray();
        rows = board.length;
        cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        boolean res = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 当且仅当单词首字母匹配时，才进入DFS
                if(word.charAt(0) == board[i][j]){
                    visited[i][j] = true;
                    res = dfs(0 + 1, board, i, j, visited);
                    visited[i][j] = false;
                    if(res){
                        return true;
                    }
                }
            }
        }
        return res;
    }

    public boolean dfs(int index, char[][] board, int x, int y, boolean[][] visited){
        if(len == index){
            return true;
        }
        int newX, newY;
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            newX = x + forward[i][0];
            newY = y + forward[i][1];
            // 没出界&&没有被访问过
            if(isOut(newX, newY) && !visited[newX][newY] && board[x][y] == words[index]){
                visited[newX][newY] = true;
                flag = flag || dfs(index + 1, board, newX, newY, visited);
                visited[newX][newY] = false;
            }
        }
        return flag;
    }

    public boolean isOut(int x, int y){
        if(x >= rows || x < 0){
            return false;
        }
        if(y >= cols || y < 0){
            return false;
        }
        return true;
    }
}
