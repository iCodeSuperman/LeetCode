package com.ToOffer;

public class Offer013 {
    private int M;
    private int N;
    private int K;
    private int counts = 0;
    private boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        this.M = m;
        this.N = n;
        this.K = k;
        visited = new boolean[m][n];
        dfs(0, 0);
        return counts;
    }

    public void dfs(int i, int j){
        if(i >= M || j >= N || visited[i][j] || sumNum(i) + sumNum(j) > K){
            return;
        }
        counts++;
        visited[i][j] = true;
        dfs(i, j + 1);
        dfs(i + 1, j);
    }

    public int sumNum(int x){
        int sum = 0;
        while(x > 0){
            sum += x % 10;
            x = x / 10;
        }
        return sum;
    }
}
