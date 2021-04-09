package com.medium;

public class M130_SurroundedRegions {
    public void solve(char[][] board) {
        if(board.length == 0) return;
        int m = board.length; // 矩阵的行数
        int n = board[0].length; // 矩阵的列数
        UF uf = new UF(m * n + 1);
        int dummy = m * n;

        // 搞定首尾行
        for(int j = 0; j < n; j++){
            if(board[0][j] == 'O'){
                uf.union(0 * n + j, dummy);
            }
            if(board[m - 1][j] == 'O'){
                uf.union((m - 1 ) * n + j, dummy);
            }
        }
        // 搞定首尾列
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O'){
                uf.union(i * n + 0, dummy);
            }
            if(board[i][n - 1] == 'O'){
                uf.union(i * n + n - 1, dummy);
            }
        }
        // 方向数组，上下左右
        int[][] d = new int[][]{{1, 0}/*右*/, {0, 1}/*下*/, {0, -1}/*上*/, {-1, 0}/*下*/};
        for(int i = 1; i < m - 1; i++){
            for(int j = 1; j < n - 1; j++){
                if(board[i][j] == 'O')
                    for(int k = 0; k < 4; k++){
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        if(board[x][y] == 'O')
                            uf.union(i * n + j, x * n + y);
                    }
            }
        }

        for(int i = 1; i < m - 1; i++){
            for(int j = 1; j < n - 1; j++){
                if(!uf.connected(dummy, i * n + j)){
                    board[i][j] = 'X';
                }
            }
        }
    }
}

class UF{
    private int count;
    private int[] parent;
    private int[] size;

    public UF(int n){
        count = n;
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ){
            return;
        }
        if(size[rootP] > size[rootQ]){
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }else{
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count --;
    }

    public int find(int x){
        while(x != parent[x]){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public boolean connected(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    public int getCount(){
        return count;
    }
}



















